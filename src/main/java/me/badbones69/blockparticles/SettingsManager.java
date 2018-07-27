package me.badbones69.blockparticles;

import me.badbones69.blockparticles.util.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class SettingsManager {
    private FileConfiguration config;
    private File configFile;
    private FileConfiguration data;
    private File dataFile;

    public SettingsManager(final Plugin plugin) {
        // Create plugin folder, save default config.yml and load it.
        plugin.saveDefaultConfig();
        configFile = new File(plugin.getDataFolder(), "config.yml");
        config = plugin.getConfig();
        // Load data.yml file, copy from jar if absent.
        dataFile = new File(plugin.getDataFolder(), "data.yml");
        if (!dataFile.exists()) {
            try {
                FileUtils.copyFileFromJar(dataFile.getName(), dataFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        data = YamlConfiguration.loadConfiguration(dataFile);
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void saveConfig() {
        try {
            config.save(configFile);
        } catch (IOException e) {
            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save config.yml!");
        }
    }

    public void reloadConfig() {
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public FileConfiguration getData() {
        return data;
    }

    public void saveData() {
        try {
            data.save(dataFile);
        } catch (IOException e) {
            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Could not save data.yml!");
        }
    }

    public void reloadData() {
        data = YamlConfiguration.loadConfiguration(dataFile);
    }
}
