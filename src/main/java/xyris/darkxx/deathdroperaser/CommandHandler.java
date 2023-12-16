package xyris.darkxx.deathdroperaser;

import com.iridium.iridiumcolorapi.IridiumColorAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandHandler implements CommandExecutor {

    private final Main plugin;
    private final List<String> subCommands = new ArrayList<>();

    public CommandHandler(Main plugin) {
        this.plugin = plugin;
        subCommands.add("reload");
        subCommands.add("enable");
        subCommands.add("disable");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!hasPermission(sender)) {
            String processedString = IridiumColorAPI.process("<GRADIENT:ff3838>You do not have permission to use this command.</GRADIENT:ff7070>");
            sender.sendMessage(processedString);
            return true;
        }

        if (args.length == 0) {
            String processedString = IridiumColorAPI.process("<GRADIENT:ff3838>Available commands: /dde reload, /dde enable, /dde disable</GRADIENT:ff7070>");
            sender.sendMessage(processedString);
            return true;
        } else if (args.length == 1) {
            String subCommand = args[0].toLowerCase();
            if (subCommands.contains(subCommand)) {
                switch (subCommand) {
                    case "reload":
                        plugin.reloadConfig();
                        String processedString = IridiumColorAPI.process("<GRADIENT:58ff2e>Done! Config Reloaded.</GRADIENT:78ff57>");
                        sender.sendMessage(processedString);
                        break;
                    case "enable":
                        plugin.setDropItems(true);
                        plugin.setDropExperience(true);
                        String enable = IridiumColorAPI.process("<GRADIENT:58ff2e>Items and experience dropping enabled.</GRADIENT:78ff57>");
                        sender.sendMessage(enable);
                        break;
                    case "disable":
                        plugin.setDropItems(false);
                        plugin.setDropExperience(false);
                        String disable = IridiumColorAPI.process("<GRADIENT:58ff2e>Items and experience dropping disabled.</GRADIENT:78ff57>");
                        sender.sendMessage(disable);
                        break;
                }
                return true;
            }
        }
        return false;
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            StringUtil.copyPartialMatches(args[0], subCommands, completions);
        }
        Collections.sort(completions);
        return completions;
    }

    private boolean hasPermission(CommandSender sender) {
        return sender instanceof ConsoleCommandSender || sender.isOp() || sender.hasPermission("dde.admin");
    }
}
