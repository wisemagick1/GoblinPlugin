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

import java.util.Random;

public class GoblinGive implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("ggive")) {
            final int UPPERBOUND = 13;
            if (args.length == 1 && args[0].length() > 2) {
                if (sender.hasPermission("Goblin.ggive.others") && sender instanceof Player) {
                    if (Bukkit.getServer().getOnlinePlayers().toString().contains(args[0])) { // This checks if args[0] is the name of a player who is online
                        Player myPlayer = Bukkit.getPlayer(args[0]);

                        Random rand = new Random(); //instance of random class
                        int i = rand.nextInt(UPPERBOUND);
                        ItemStack[] items = {new ItemStack(Material.DANDELION, 1), new ItemStack(Material.POPPY, 1), new ItemStack(Material.BLUE_ORCHID, 1), new ItemStack(Material.ALLIUM, 1), new ItemStack(Material.AZURE_BLUET, 1), new ItemStack(Material.RED_TULIP, 1), new ItemStack(Material.WHITE_TULIP, 1), new ItemStack(Material.ORANGE_TULIP, 1), new ItemStack(Material.PINK_TULIP, 1), new ItemStack(Material.OXEYE_DAISY, 1), new ItemStack(Material.CORNFLOWER, 1), new ItemStack(Material.LILY_OF_THE_VALLEY, 1), new ItemStack(Material.WITHER_ROSE, 1)};
                        myPlayer.getInventory().addItem(items[i]);
                            sender.sendMessage("You have given " + myPlayer.getDisplayName() + " a flower!");
                            myPlayer.sendMessage("You have been given a flower by " + ((Player) sender).getDisplayName() + "!");
                        } else {
                            sender.sendMessage(ChatColor.DARK_RED + "Player is not online!");
                        }
                    } else
                    {
                        if (!sender.hasPermission("Goblin.ggive.others") && sender instanceof Player) {
                            Player player = (Player) sender;
                            player.sendMessage(ChatColor.DARK_RED + "No permission!");
                        }
                    }
                } else {
                    if (args.length == 0 && sender instanceof Player && sender.hasPermission("Goblin.ggive")) {
                        Player player = (Player) sender;
                        Random rand = new Random(); //instance of random class
                        int i = rand.nextInt(UPPERBOUND);
                        ItemStack[] items = {new ItemStack(Material.DANDELION, 1), new ItemStack(Material.POPPY, 1), new ItemStack(Material.BLUE_ORCHID, 1), new ItemStack(Material.ALLIUM, 1), new ItemStack(Material.AZURE_BLUET, 1), new ItemStack(Material.RED_TULIP, 1), new ItemStack(Material.WHITE_TULIP, 1), new ItemStack(Material.ORANGE_TULIP, 1), new ItemStack(Material.PINK_TULIP, 1), new ItemStack(Material.OXEYE_DAISY, 1), new ItemStack(Material.CORNFLOWER, 1), new ItemStack(Material.LILY_OF_THE_VALLEY, 1), new ItemStack(Material.WITHER_ROSE, 1)};
                        player.sendMessage("Have a flower!");
                        player.getInventory().addItem(items[i]);
                    } else {
                        if (args.length == 0 && sender instanceof Player && !sender.hasPermission("Goblin.ggive")) {
                            Player player = (Player) sender;
                            player.sendMessage(ChatColor.DARK_RED + "No permission!");
                        }
                    }
                }


            } else if (args.length == 0 && sender instanceof ConsoleCommandSender) {
                sender.sendMessage("Invalid command args! Usage: /ggive <player>");
            }

        return true;}

    }












