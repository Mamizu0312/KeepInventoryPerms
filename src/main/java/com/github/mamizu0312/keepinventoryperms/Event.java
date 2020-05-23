package com.github.mamizu0312.keepinventoryperms;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.entity.PlayerDeathEvent;

public class Event implements Listener {

    KeepInventoryPerms plugin;

    public Event(KeepInventoryPerms plugin) {

        this.plugin = plugin;

    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {

        if(e == null) return;

        Player p = e.getEntity().getPlayer();

        if(p.hasPermission("kip.enable") && plugin.targetworld.contains(p.getWorld().getName())) {

            e.setKeepInventory(true);

            e.setKeepLevel(true);

            e.getDrops().clear();

            e.setDroppedExp(0);

            p.sendMessage(plugin.prefix + "デスドロップが無効化されました。");

        }

    }
}
