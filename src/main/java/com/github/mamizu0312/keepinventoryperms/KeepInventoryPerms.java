package com.github.mamizu0312.keepinventoryperms;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class KeepInventoryPerms extends JavaPlugin {

    String prefix = "§7[§e§lKeepInventoryPerms§r§7]§r";

    List<String> targetworld = new ArrayList<>();

    @Override
    public void onEnable() {

        this.saveDefaultConfig();

        targetworld = this.getConfig().getStringList("worlds");

        Bukkit.getServer().getPluginManager().registerEvents(new Event(this), this);


        getCommand("kip").setExecutor(new command(this));

        Bukkit.getLogger().info("KeepInventoryPerms enabled.");

    }

    @Override
    public void onDisable() {

        Bukkit.getLogger().info("KeepInventoryPerms disabled.");

    }


}
