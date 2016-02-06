package PotatoHubMain.Inventories;

import PotatoHubMain.ItemStacks;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;

public class LocationConfigurationInventory implements Listener {

    public static Inventory configureLocations() {
        Inventory inv = Bukkit.createInventory(null, 54, ChatColor.GOLD + "Configure Locations");
        inv.setItem(2 , ItemStacks.anorthpearl());
        inv.setItem(10, ItemStacks.anorthwestpearl());
        inv.setItem(12, ItemStacks.anortheastpearl());
        inv.setItem(18, ItemStacks.awestpearl());
        inv.setItem(20, ItemStacks.aspawnpearl());
        inv.setItem(22, ItemStacks.aeastpearl());
        inv.setItem(28, ItemStacks.asouthwestpearl());
        inv.setItem(30, ItemStacks.asoutheastpearl());
        inv.setItem(38, ItemStacks.asouthpearl());
        return inv;
    }

    @EventHandler
    public void clickCancel(InventoryClickEvent e) {
        Inventory inv = e.getClickedInventory();
        String name = configureLocations().getName();
        if (inv != null) {
            if (inv.getName().equals(name)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void invInteract(InventoryClickEvent e) {
        Inventory inv = e.getClickedInventory();
        String name = configureLocations().getName();
        Player player = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();
        Location loc = player.getLocation();
        if (inv != null) {
            if (inv.getName().equals(name)) {
                if (item.equals(ItemStacks.anorthpearl())) {
                    locSaver(loc, "Hub.Locations.North", player);
                } else if (item.equals(ItemStacks.asouthpearl())) {
                    locSaver(loc, "Hub.Locations.South", player);
                } else if (item.equals(ItemStacks.aeastpearl())) {
                    locSaver(loc, "Hub.Locations.East", player);
                } else if (item.equals(ItemStacks.awestpearl())) {
                    locSaver(loc, "Hub.Locations.West", player);
                } else if (item.equals(ItemStacks.aspawnpearl())) {
                    locSaver(loc, "Hub.Locations.Center", player);
                } else if (item.equals(ItemStacks.anortheastpearl())) {
                    locSaver(loc, "Hub.Locations.North_East", player);
                } else if (item.equals(ItemStacks.anorthwestpearl())) {
                    locSaver(loc, "Hub.Locations.North_West", player);
                } else if (item.equals(ItemStacks.asoutheastpearl())) {
                    locSaver(loc, "Hub.Locations.South_East", player);
                } else if (item.equals(ItemStacks.asouthwestpearl())) {
                    locSaver(loc, "Hub.Locations.South_West", player);
                }
            }
        }
    }

    private void locSaver(Location loc, String string, Player player) {

        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("PotatoHub") + "/Hub Locations.yml");
        YamlConfiguration myFile = YamlConfiguration.loadConfiguration(file);

        String world = loc.getWorld().getName();
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        float yaw = loc.getYaw();
        float pitch = loc.getPitch();

        myFile.set(string + ".World", world);
        myFile.set(string + ".X", x);
        myFile.set(string + ".Y", y);
        myFile.set(string + ".Z", z);
        myFile.set(string + ".Yaw", yaw);
        myFile.set(string + ".Pitch", pitch);
        try {
            myFile.save(file);
            player.sendMessage("Location Configured!");
        } catch (IOException e) {
            e.printStackTrace();
            player.sendMessage(ChatColor.RED + "Error configuring location!");
        }
    }

}
