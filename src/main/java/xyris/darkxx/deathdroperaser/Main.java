package xyris.darkxx.deathdroperaser;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin implements Listener {

    private boolean dropItems;
    private boolean dropExperience;

    @Override
    public void onEnable() {
        loadConfig();
        getServer().getPluginManager().registerEvents(this, this);
        getCommand("dde").setExecutor(new CommandHandler(this));
        getCommand("dde").setTabCompleter(new CommandTabCompleter());
    }

    private void loadConfig() {
        File configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }
        FileConfiguration config = getConfig();
        dropItems = config.getBoolean("drop_items", true);
        dropExperience = config.getBoolean("drop_experience", true);
    }

    boolean shouldDropItems() {
        return dropItems;
    }

    boolean shouldDropExperience() {
        return dropExperience;
    }

    void setDropItems(boolean dropItems) {
        this.dropItems = dropItems;
        getConfig().set("drop_items", dropItems);
        saveConfig();
    }

    void setDropExperience(boolean dropExperience) {
        this.dropExperience = dropExperience;
        getConfig().set("drop_experience", dropExperience);
        saveConfig();
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        if (!shouldDropItems()) {
            event.getDrops().clear();
            player.getInventory().clear();
        }
        if (!shouldDropExperience()) {
            event.setDroppedExp(0);
        }
    }
}
