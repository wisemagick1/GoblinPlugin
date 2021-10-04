package me.wisemagick1.goblin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;


public class Yeet implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Plugin plugin = (Plugin) new Main();
        if (cmd.getName().equalsIgnoreCase("yeet")) {
            if (args.length == 1 && args[0].length() > 2) { // Minecraft username must be at least 3 characters long
                if (Bukkit.getServer().getOnlinePlayers().toString().contains(args[0])) { // This checks if args[0] is the name of a player who is online
                    Player myPlayer = Bukkit.getPlayer(args[0]);

                    if (sender == myPlayer){
                        sender.sendMessage("Haha! YOU HAVE BEEN YEETED!");
                    } else {
                        sender.sendMessage("You have yeeted " + myPlayer.getName() + " into the air. They may never return.");
                        myPlayer.sendMessage(sender.getName() + " yeeted you.");
                    }

                    new BukkitRunnable() {
                        int counter = 3;

                        public void run() {
                            myPlayer.setGravity(false);
                            myPlayer.setAllowFlight(true);
                            myPlayer.setVelocity(new Vector(0, 1000, 0));
                            counter--;
                            if (counter == 0) {
                                myPlayer.setGravity(true);
                                myPlayer.setAllowFlight(false);
                                cancel();
                            }
                        }


                    }.runTaskTimerAsynchronously(plugin,0,30);

                } else {
                    sender.sendMessage(args[0] + " is not online right now!"); // sends a player a message if args[0] is not a player or if the player is not online
                }

            } else {
                sender.sendMessage("Invalid command args! Usage: /yeet <player>");
            }
        }

        return true;
}
}
