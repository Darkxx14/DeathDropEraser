package xyris.darkxx.deathdroperaser;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandTabCompleter implements TabCompleter {

    private final List<String> subCommands = new ArrayList<>();

    public CommandTabCompleter() {
        subCommands.add("reload");
        subCommands.add("enable");
        subCommands.add("disable");
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            StringUtil.copyPartialMatches(args[0], subCommands, completions);
        }
        Collections.sort(completions);
        return completions;
    }
}
