package gps.main;

import gps.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class Events extends Utils implements Listener {
    public SpigotPlugin plugin;

    public Events(SpigotPlugin plugin) {
        super(plugin);
        this.plugin = plugin;
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        ItemStack stack = e.getItemDrop().getItemStack();
        Player p = e.getPlayer();
        if (stack.equals(compass)) {
            e.getItemDrop().remove();
            p.sendTitle(ChatColor.translateAlternateColorCodes('&', "&6&lОтмена GPS-трекера..."), ChatColor.GREEN + "Успешно!");
            remove(p);
            p.getInventory().removeItem(compass);
        }
    }
}