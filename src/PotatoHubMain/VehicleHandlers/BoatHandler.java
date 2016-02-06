package PotatoHubMain.VehicleHandlers;

import org.bukkit.Location;
import org.bukkit.entity.Boat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class BoatHandler implements Listener {

    public static Boat boat(Location location, Player player) {
        Boat boat = location.getWorld().spawn(location, Boat.class);
        boat.setPassenger(player);
        return boat;
    }

    @EventHandler
    public void onBoatLeave(VehicleExitEvent e) {
        Vehicle vehicle = e.getVehicle();
        if (vehicle.getType().equals(EntityType.BOAT)) {
            vehicle.remove();
        }
    }

    @EventHandler
    public void onBoatBreak(VehicleDestroyEvent e) {
        Vehicle vehicle = e.getVehicle();
        if (vehicle.getType().equals(EntityType.BOAT)) {
            e.setCancelled(true);
        }
    }

}
