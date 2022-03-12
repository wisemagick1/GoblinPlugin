package me.wisemagick1.goblin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Rainbow implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("rainbow")) {
            if (args.length == 1 && args[0].length() > 2)
                if (sender.hasPermission("Goblin.rainbow.others") && sender instanceof Player) {
                    if (Bukkit.getServer().getOnlinePlayers().toString().contains(args[0])) { // This checks if args[0] is the name of a player who is online
                        Player myPlayer = Bukkit.getPlayer(args[0]);


                        ItemStack[] items = {new ItemStack(Material.RED_WOOL, 64), new ItemStack(Material.ORANGE_WOOL, 64), new ItemStack(Material.YELLOW_WOOL, 64), new ItemStack(Material.GREEN_WOOL, 64), new ItemStack(Material.BLUE_WOOL, 64), new ItemStack(Material.PURPLE_WOOL, 64), new ItemStack(Material.MAGENTA_WOOL, 64)};
                        myPlayer.getInventory().addItem(items);
                        sender.sendMessage("You have given " + myPlayer.getDisplayName() + " a rainbow!");
                        myPlayer.sendMessage("You have been given a rainbow by " + ((Player) sender).getDisplayName() + "!");
                    } else {
                        sender.sendMessage(ChatColor.DARK_RED + "Player is not online!");
                    }
                } else {
                    if (!sender.hasPermission("Goblin.rainbow.others") && sender instanceof Player) {
                        Player player = (Player) sender;
                        player.sendMessage(ChatColor.DARK_RED + "No permission!");
                    }
                }
        } else {
            if (args.length == 0 && sender instanceof Player && sender.hasPermission("Goblin.rainbow")) {
                Player player = (Player) sender;
                ItemStack[] items = {new ItemStack(Material.RED_WOOL, 64), new ItemStack(Material.ORANGE_WOOL, 64), new ItemStack(Material.YELLOW_WOOL, 64), new ItemStack(Material.GREEN_WOOL, 64), new ItemStack(Material.BLUE_WOOL, 64), new ItemStack(Material.PURPLE_WOOL, 64), new ItemStack(Material.MAGENTA_WOOL, 64)};
                player.sendMessage("Have a rainbow!");
                player.getInventory().addItem(items);
            } else {
                if (args.length == 0 && sender instanceof Player && !sender.hasPermission("Goblin.rainbow")) {
                    Player player = (Player) sender;
                    player.sendMessage(ChatColor.DARK_RED + "No permission!");
                } else if (args.length == 0 && sender instanceof ConsoleCommandSender) {
                    sender.sendMessage("Invalid command args! Usage: /rainbow <player>");
                }
            }
        }
        return true;
    }
}















