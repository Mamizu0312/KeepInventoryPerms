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

            if(args.length == 0 || args[0].equalsIgnoreCase("help")) {

                sender.sendMessage(plugin.prefix);

                sender.sendMessage("kip help   : このページ(ヘルプ)を開きます");
                sender.sendMessage("          : open this (help) page ");

                sender.sendMessage("kip reload : configファイルをリロードします");
                sender.sendMessage("          : reload the config file");
                sender.sendMessage("Developed by Mamizu0312");

                return true;

            }

            if(args[0].equalsIgnoreCase("reload")) {

                plugin.reloadConfig();

                plugin.targetworld = plugin.getConfig().getStringList("worlds");

                sender.sendMessage(plugin.prefix + "configがリロードされました / config has been reloaded");

                return true;
            }

            return true;

        }


        Player p = (Player)sender;

        if(args.length == 0 || args[0].equalsIgnoreCase("help")) {

            p.sendMessage(plugin.prefix);

            p.sendMessage("/kip help   : このページ(ヘルプ)を開きます");
            p.sendMessage("            : open this (help) page ");

            p.sendMessage("/kip reload : configファイルをリロードします");
            p.sendMessage("            : reload the config file");
            p.sendMessage("Developed by Mamizu0312");

            return true;

        }

        if(args.length == 1) {

            if(args[0].equalsIgnoreCase("on")) {

                if(!p.hasPermission("kip.enable")) {

                    p.sendMessage(plugin.prefix + "§cあなたは権限を持っていません / You don't have permission");

                    return true;

                }

                plugin.playerOnOrOff.put(p.getUniqueId(), true);

                p.sendMessage(plugin.prefix + "デスドロップ防止を有効にしました / Enabled deathdrop prevention");

                return true;

            }

            if(args[0].equalsIgnoreCase("off")) {

                if(!p.hasPermission("kip.enable")) {

                    p.sendMessage(plugin.prefix + "§cあなたは権限を持っていません / You don't have permission");

                    return true;

                }

                plugin.playerOnOrOff.put(p.getUniqueId(), false);

                p.sendMessage(plugin.prefix + "ですドロップ防止を無効にしました / Disabled deathdrop prevention");

                return true;

            }

            if(args[0].equalsIgnoreCase("reload")) {

                if(!p.hasPermission("kip.admin")) {

                    p.sendMessage(plugin.prefix + "§cあなたは権限を持っていません / You don't have permission");

                    return true;

                }

                plugin.reloadConfig();

                plugin.targetworld = plugin.getConfig().getStringList("worlds");

                p.sendMessage(plugin.prefix + "configがリロードされました / Config has been reloaded");

                return true;
            }

        }


        return true;
    }

}
