package PotatoHubMain.Commands;

import PotatoHubMain.Inventories.HubMenuInventory;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;

public class HubMenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender instanceof Player) {
            File file = new File(Bukkit.getServer().getPluginManager().getPlugin("PotatoHub").getDataFolder() + "/Hub Locations.yml");
            Player player = (Player) sender;
            if (file.exists()) {
                player.openInventory(HubMenuInventory.hubMenu());
                return true;
            } else {
                player.sendMessage(ChatColor.RED + "Certain locations may have not been set around The Hub.");
                return true;
            }
        }
        return false;
    }
}
