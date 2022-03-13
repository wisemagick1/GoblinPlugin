package me.wisemagick1.goblin.commands;



import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
public class Bees implements CommandExecutor {



    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("Bees")) {


            if (args.length == 1 && args[0].length() > 2) {
                        if (sender.hasPermission("Goblin.bees.others")) {
                    if (Bukkit.getServer().getOnlinePlayers().toString().contains(args[0])) { // This checks if args[0] is the name of a player who is online
                        Player myPlayer = Bukkit.getPlayer(args[0]);
                        Location loc = myPlayer.getLocation();
                        for (int counter = 21; counter > 0; counter--) {
                            Entity entity = myPlayer.getWorld().spawnEntity(loc, EntityType.BEE);
                            Bee bee = (Bee) entity;
                            bee.setHasStung(true);
                            bee.setHealth(0.2);
                            bee.setGlowing(true);
                            bee.setBreed(false);
                        }
                    myPlayer.sendMessage("BEES?!?!?!?");}
                }
            }
            else if (args.length == 0 && sender instanceof Player) {
                Player player = (Player) sender;
                Location loc = player.getLocation();

                for (int counter = 21; counter > 0; counter--) {
                    Entity entity = player.getWorld().spawnEntity(loc, EntityType.BEE);
                    Bee bee = (Bee) entity;
                    bee.setHasStung(true);
                    bee.setHealth(0.2);
                    bee.setGlowing(true);
                    bee.setBreed(false);



                }
                player.sendMessage("BEES?!?!?!?");






            }
        } return true;
    }
}