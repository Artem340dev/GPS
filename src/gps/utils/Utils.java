package gps.utils;

import gps.main.SpigotPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public abstract class Utils {
    public ItemStack compass = item(ChatColor.GREEN + "GPS", Arrays.asList("", ChatColor.GRAY + "Выкиньте чтобы отменить слежку по GPS"), Material.COMPASS);
    public SpigotPlugin plugin;

    public Utils(SpigotPlugin plugin) {
        this.plugin = plugin;
    }

    public ItemStack item(String name, List<String> lore, Material mat) {
        ItemStack i = new ItemStack(mat);
        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        i.setItemMeta(meta);
        return i;
    }

    public double distance(Location loc1, Location loc2) {
        return loc1.distance(loc2);
    }

    public boolean contains(Player p) {
        if (plugin.gps.contains(p)) {
            return true;
        } else {
            return false;
        }
    }

    public void remove(Player p) {
        plugin.gps.remove(p);
    }

    public void add(Player p) {
        plugin.gps.add(p);
    }
}