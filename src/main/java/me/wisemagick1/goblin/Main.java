package me.wisemagick1.goblin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;


import java.sql.SQLOutput;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        this.getCommand("Bees").setExecutor(new Bees());
        this.getCommand("ggive").setExecutor(new GoblinGive());




    }

    @Override

    public void onDisable() {
        // Plugin shutdown logic
    }




    }

