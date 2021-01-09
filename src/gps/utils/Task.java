package gps.utils;

import gps.main.SpigotPlugin;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Task extends Utils {
    public Player sender, p;

    public Task(SpigotPlugin plugin, Player sender, Player p) {
        super(plugin);
        this.sender = sender;
        this.p = p;
    }

    public void taskMessage(int dist) {
        sender.sendTitle(ChatColor.translateAlternateColorCodes('&', "&6&lДо игрока " + p.getName() + " осталось"), ChatColor.GREEN + String.valueOf(dist) + " блоков");
    }

    public void end() {
        sender.sendTitle(ChatColor.translateAlternateColorCodes('&', "&6&lВы успешно пришли к игроку" + p.getName() + "!"), ChatColor.GREEN + "Успешно!");
        remove(sender);
        sender.getInventory().removeItem(compass);
    }
}