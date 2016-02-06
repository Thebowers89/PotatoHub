package PotatoHubMain;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemStacks {

    public static ItemStack bglass() {

        ItemStack bglass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 12);
        ItemMeta mbglass = bglass.getItemMeta();
        mbglass.setDisplayName(" ");
        bglass.setItemMeta(mbglass);

        return bglass;
    }

    public static ItemStack gglass() {

        ItemStack gglass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 13);
        ItemMeta mgglass = gglass.getItemMeta();
        mgglass.setDisplayName(" ");
        gglass.setItemMeta(mgglass);

        return gglass;
    }

    public static ItemStack speed1() {

        ItemStack lglass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
        ItemMeta mlglass = lglass.getItemMeta();
        mlglass.setDisplayName(ChatColor.GREEN + "Speed I");
        lglass.setItemMeta(mlglass);

        return lglass;
    }

    public static ItemStack speed2() {

        ItemStack yglass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 4);
        ItemMeta myglass = yglass.getItemMeta();
        myglass.setDisplayName(ChatColor.YELLOW + "Speed II");
        yglass.setItemMeta(myglass);

        return yglass;
    }

    public static ItemStack speed3() {

        ItemStack oglass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 1);
        ItemMeta moglass = oglass.getItemMeta();
        moglass.setDisplayName(ChatColor.GOLD + "Speed III");
        oglass.setItemMeta(moglass);

        return oglass;
    }

    public static ItemStack speedReset() {

        ItemStack potato = new ItemStack(Material.POTATO_ITEM);
        ItemMeta mpotato = potato.getItemMeta();
        mpotato.setDisplayName(ChatColor.AQUA + "Speed Reset");
        potato.setItemMeta(mpotato);

        return potato;
    }

    public static ItemStack speed4() {

        ItemStack bpotato = new ItemStack(Material.BAKED_POTATO);
        ItemMeta mbpotato = bpotato.getItemMeta();
        mbpotato.setDisplayName(ChatColor.DARK_RED + "POTATO SPEED");
        bpotato.setItemMeta(mbpotato);

        return bpotato;
    }

    public static ItemStack northpearl() {

        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta mpearl = pearl.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add("PVP");
        mpearl.setDisplayName("North");
        mpearl.setLore(lore);
        pearl.setItemMeta(mpearl);

        return pearl;
    }

    public static ItemStack eastpearl() {

        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta mpearl = pearl.getItemMeta();
        mpearl.setDisplayName("East");
        pearl.setItemMeta(mpearl);

        return pearl;
    }

    public static ItemStack southpearl() {

        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta mpearl = pearl.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add("Survival");
        mpearl.setDisplayName("South");
        mpearl.setLore(lore);
        pearl.setItemMeta(mpearl);

        return pearl;
    }

    public static ItemStack westpearl() {

        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta mpearl = pearl.getItemMeta();
        mpearl.setDisplayName("West");
        pearl.setItemMeta(mpearl);

        return pearl;
    }

    public static ItemStack northeastpearl() {

        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta mpearl = pearl.getItemMeta();
        mpearl.setDisplayName("North East");
        pearl.setItemMeta(mpearl);

        return pearl;
    }

    public static ItemStack northwestpearl() {

        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta mpearl = pearl.getItemMeta();
        mpearl.setDisplayName("North West");
        pearl.setItemMeta(mpearl);

        return pearl;
    }

    public static ItemStack southeastpearl() {

        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta mpearl = pearl.getItemMeta();
        mpearl.setDisplayName("South East");
        pearl.setItemMeta(mpearl);

        return pearl;
    }

    public static ItemStack southwestpearl() {

        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta mpearl = pearl.getItemMeta();
        mpearl.setDisplayName("South West");
        pearl.setItemMeta(mpearl);

        return pearl;
    }

    public static ItemStack spawnpearl() {

        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta mpearl = pearl.getItemMeta();
        mpearl.setDisplayName("Center");
        pearl.setItemMeta(mpearl);

        return pearl;
    }

    public static ItemStack spawnBoat() {
        ItemStack boat = new ItemStack(Material.BOAT);
        ItemMeta boatMeta = boat.getItemMeta();
        boatMeta.setDisplayName(ChatColor.AQUA + "Spawn Boat");
        boat.setItemMeta(boatMeta);
        return boat;
    }

    public static ItemStack spawnPig() {
        ItemStack pig = new ItemStack(Material.MONSTER_EGG, 1, (short) 90);
        ItemMeta pigMeta = pig.getItemMeta();
        pigMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Spawn Pig");
        pig.setItemMeta(pigMeta);
        return pig;
    }

    public static ItemStack anorthpearl() {

        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta mpearl = pearl.getItemMeta();
        mpearl.setDisplayName("Configure North");
        pearl.setItemMeta(mpearl);

        return pearl;
    }

    public static ItemStack aeastpearl() {

        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta mpearl = pearl.getItemMeta();
        mpearl.setDisplayName("Configure East");
        pearl.setItemMeta(mpearl);

        return pearl;
    }

    public static ItemStack asouthpearl() {

        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta mpearl = pearl.getItemMeta();
        mpearl.setDisplayName("Configure South");
        pearl.setItemMeta(mpearl);

        return pearl;
    }

    public static ItemStack awestpearl() {

        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta mpearl = pearl.getItemMeta();
        mpearl.setDisplayName("Configure West");
        pearl.setItemMeta(mpearl);

        return pearl;
    }

    public static ItemStack anortheastpearl() {

        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta mpearl = pearl.getItemMeta();
        mpearl.setDisplayName("Configure North East");
        pearl.setItemMeta(mpearl);

        return pearl;
    }

    public static ItemStack anorthwestpearl() {

        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta mpearl = pearl.getItemMeta();
        mpearl.setDisplayName("Configure North West");
        pearl.setItemMeta(mpearl);

        return pearl;
    }

    public static ItemStack asoutheastpearl() {

        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta mpearl = pearl.getItemMeta();
        mpearl.setDisplayName("Configure South East");
        pearl.setItemMeta(mpearl);

        return pearl;
    }

    public static ItemStack asouthwestpearl() {

        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta mpearl = pearl.getItemMeta();
        mpearl.setDisplayName("Configure South West");
        pearl.setItemMeta(mpearl);

        return pearl;
    }

    public static ItemStack aspawnpearl() {

        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta mpearl = pearl.getItemMeta();
        mpearl.setDisplayName("Configure Center");
        pearl.setItemMeta(mpearl);

        return pearl;
    }

}
