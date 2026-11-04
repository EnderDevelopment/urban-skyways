package com.enderdevelopment.plugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Plugin enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Plugin disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("ciao")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage(Component.text("Ciao, ").color(NamedTextColor.GOLD)
                        .append(Component.text(player.getName()).color(NamedTextColor.AQUA)));
                return true;
            } else {
                sender.sendMessage("This command can only be run by a player.");
                return false;
            }
        }
        return false;
    }
}