package PotatoHubMain.Inventories;

import PotatoHubMain.ItemStacks;
import PotatoHubMain.VehicleHandlers.BoatHandler;
import PotatoHubMain.VehicleHandlers.PigHandler;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.Set;

public class HubMenuInventory implements Listener {

    public static Inventory hubMenu() {
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.DARK_GREEN + "Hub Menu");
        for (int i = 0; i <= 53; i++) {
            inv.setItem(i, ItemStacks.gglass());
        }
        for (int i = 0; i <= 4; i++) {
            inv.setItem(i, ItemStacks.bglass());
        }
        for (int i = 9; i <= 13; i++) {
            inv.setItem(i, ItemStacks.bglass());
        }
        for (int i = 18; i <= 22; i++) {
            inv.setItem(i, ItemStacks.bglass());
        }
        for (int i = 27; i <= 31; i++) {
            inv.setItem(i, ItemStacks.bglass());
        }
        for (int i = 36; i <= 40; i++) {
            inv.setItem(i, ItemStacks.bglass());
        }
        inv.setItem(2, ItemStacks.northpearl());
        inv.setItem(10, ItemStacks.northwestpearl());
        inv.setItem(12, ItemStacks.northeastpearl());
        inv.setItem(18, ItemStacks.westpearl());
        inv.setItem(20, ItemStacks.spawnpearl());
        inv.setItem(22, ItemStacks.eastpearl());
        inv.setItem(28, ItemStacks.southwestpearl());
        inv.setItem(30, ItemStacks.southeastpearl());
        inv.setItem(38, ItemStacks.southpearl());
        inv.setItem(7, ItemStacks.speed4());
        inv.setItem(16, ItemStacks.speed3());
        inv.setItem(25, ItemStacks.speed2());
        inv.setItem(34, ItemStacks.speed1());
        inv.setItem(43, ItemStacks.speedReset());
        inv.setItem(52, ItemStacks.spawnBoat());
        //inv.setItem(53, ItemStacks.spawnPig());
        return inv;
    }

    @EventHandler
    public void clickCancel(InventoryClickEvent e) {
        Inventory inv = e.getClickedInventory();
        String name = hubMenu().getName();
        if (inv != null) {
            if (inv.getName().equals(name)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void invInteract(InventoryClickEvent e) {
        Inventory inv = e.getClickedInventory();
        String name = hubMenu().getName();
        Player player = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();
        if (inv != null) {
            if (inv.getName().equals(name)) {
                if (item.equals(ItemStacks.bglass()) && player.isOp() || item.equals(ItemStacks.bglass()) && player.getName().equals("Kerlab")) {
                    player.closeInventory();
                    player.openInventory(LocationConfigurationInventory.configureLocations());
                } else if (item.equals(ItemStacks.northpearl())) {
                    player.teleport(location("Hub.Locations.North"));
                } else if (item.equals(ItemStacks.southpearl())) {
                    player.teleport(location("Hub.Locations.South"));
                } else if (item.equals(ItemStacks.eastpearl())) {
                    player.teleport(location("Hub.Locations.East"));
                } else if (item.equals(ItemStacks.westpearl())) {
                    player.teleport(location("Hub.Locations.West"));
                } else if (item.equals(ItemStacks.spawnpearl())) {
                    player.teleport(location("Hub.Locations.Center"));
                } else if (item.equals(ItemStacks.northeastpearl())) {
                    player.teleport(location("Hub.Locations.North_East"));
                } else if (item.equals(ItemStacks.northwestpearl())) {
                    player.teleport(location("Hub.Locations.North_West"));
                } else if (item.equals(ItemStacks.southeastpearl())) {
                    player.teleport(location("Hub.Locations.South_East"));
                } else if (item.equals(ItemStacks.southwestpearl())) {
                    player.teleport(location("Hub.Locations.South_West"));
                } else if (item.equals(ItemStacks.spawnBoat())) {
                    spawnBoat(player);
                } else if (item.equals(ItemStacks.spawnPig())) {
                    spawnPig(player);
                }
            }
        }
    }

    private Location location(String string) {
        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("PotatoHub") + "/Hub Locations.yml");
        YamlConfiguration myFile = YamlConfiguration.loadConfiguration(file);

        World w = Bukkit.getWorld(myFile.getString(string + ".World"));
        double x = myFile.getDouble(string + ".X");
        double y = myFile.getDouble(string + ".Y");
        double z = myFile.getDouble(string + ".Z");
        float yaw = (float) myFile.getDouble(string + ".Yaw");
        float pitch = (float) myFile.getDouble(string + ".Pitch");

        Location loc = new Location(w, x, y, z, yaw, pitch);
        return loc;
    }

    private void spawnBoat(Player player) {
        if (!player.isInsideVehicle()) {
            Block thing = player.getTargetBlock((Set) null, 5);
            if (thing.getType().equals(Material.STATIONARY_WATER)) {
                Location loc = thing.getLocation().add(0.0, 1.0, 0.0);
                BoatHandler.boat(loc, player);
            } else {
                player.sendMessage(ChatColor.RED + "You need to be looking at water or you need to be closer to the water to spawn a boat.");
            }
        } else {
            player.sendMessage(ChatColor.RED + "I'm sorry, you cannot have multiple boats.");
        }
    }

    private void spawnPig(Player player) {
        if (!player.isInsideVehicle()) {
            Location location = player.getLocation().add(0.0, 1.0, 0.0);
            PigHandler.pig(location, player);
            player.getInventory().addItem(new ItemStack(Material.CARROT_STICK));
        } else {
            player.sendMessage("I'm sorry, you can not have multiple pigs.");
        }
    }

}
