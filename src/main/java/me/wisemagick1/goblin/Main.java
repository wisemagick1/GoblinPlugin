package me.wisemagick1.goblin;

import me.wisemagick1.goblin.commands.Bees;
import me.wisemagick1.goblin.commands.GoblinGive;
import org.bukkit.plugin.java.JavaPlugin;

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

