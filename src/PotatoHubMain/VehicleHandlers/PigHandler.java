package PotatoHubMain.VehicleHandlers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class PigHandler implements Listener {

    public static Pig pig(Location location, Player player) {
        Pig pig = location.getWorld().spawn(location, Pig.class);
        pig.setCustomNameVisible(true);
        pig.setCustomName("Lil' Pig");
        pig.setSaddle(true);
        pig.setPassenger(player);
        return pig;
    }

    @EventHandler
    public void onPigLeave(VehicleExitEvent e) {
        Vehicle vehicle = e.getVehicle();
        Player player = (Player) e.getExited();
        if (vehicle.getType().equals(EntityType.PIG)) {
            vehicle.remove();
            player.getInventory().remove(Material.CARROT_STICK);
        }
    }

    @EventHandler
    public void onPigDie(VehicleDestroyEvent e) {
        Vehicle vehicle = e.getVehicle();
        if (vehicle.getType().equals(EntityType.PIG)) {
            e.setCancelled(true);
        }
    }

}
