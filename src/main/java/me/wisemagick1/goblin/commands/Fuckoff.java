package me.wisemagick1.goblin.commands;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fuckoff implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("fuckoff")) {
            if (args.length == 1 && args[0].length() > 2) {
                if (Bukkit.getServer().getOnlinePlayers().toString().contains(args[0])) { // This checks if args[0] is the name of a player who is online
                    Player myPlayer = Bukkit.getPlayer(args[0]);
                    Bukkit.getBanList(BanList.Type.NAME).addBan(args[0], "Fuckoff", null, sender.getName());
                    myPlayer.kickPlayer("Fuck off!");
                }
            }
        }
                return false;
    }
}
