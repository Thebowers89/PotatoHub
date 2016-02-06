package PotatoHubMain;

import PotatoHubMain.Commands.HubMenuCommand;
import PotatoHubMain.Inventories.HubMenuInventory;
import PotatoHubMain.Inventories.LocationConfigurationInventory;
import PotatoHubMain.VehicleHandlers.BoatHandler;
import PotatoHubMain.VehicleHandlers.PigHandler;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class PotatoHub extends JavaPlugin {

    public void onEnable() {
        registerCommands();
        registerEvents();
        verifyFiles();
    }

    public void onDisable() {

    }

    private void registerCommands() {
        getCommand("hubmenu").setExecutor(new HubMenuCommand());
    }

    private void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new HubMenuInventory(), this);
        pm.registerEvents(new LocationConfigurationInventory(), this);
        pm.registerEvents(new BoatHandler(), this);
        pm.registerEvents(new PigHandler(), this);
    }

    private void verifyFiles() {
        File file = new File(getDataFolder() + "/Hub Locations.yml");
        YamlConfiguration myFile = YamlConfiguration.loadConfiguration(file);
        if (!file.exists()) {
            try {
                myFile.save(file);
                System.out.println("[PotatoHub] Generating Locations File!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("[PotatoHub] Locations File existence verified!");
        }
    }

}
