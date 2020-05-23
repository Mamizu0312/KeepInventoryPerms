package com.github.mamizu0312.keepinventoryperms;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class command implements CommandExecutor{

    KeepInventoryPerms plugin;

    public command(KeepInventoryPerms plugin) {

        this.plugin = plugin;

    }

    @Override

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if(!(sender instanceof Player)) {

            sender.sendMessage(plugin.prefix + "現在未対応");

            return true;

        }


        Player p = (Player)sender;

        if(args.length == 0 || args[0].equalsIgnoreCase("help")) {

            p.sendMessage(plugin.prefix);

            p.sendMessage("/kip help   : このページ(ヘルプ)を開きます");

            p.sendMessage("/kip reload : configファイルをリロードします");

            return true;

        }

        if(args[0].equalsIgnoreCase("reload")) {

            plugin.reloadConfig();

            plugin.targetworld = plugin.getConfig().getStringList("worlds");

            p.sendMessage(plugin.prefix + "configがリロードされました。");

            return true;
        }

        return true;
    }

}
