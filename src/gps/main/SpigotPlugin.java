package gps.main;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class SpigotPlugin extends JavaPlugin {
    public List<Player> gps = new ArrayList<>();

    public void onEnable() {
        getCommand("gps").setExecutor(new GPS(this));
        Bukkit.getPluginManager().registerEvents(new Events(this), this);
    }
}