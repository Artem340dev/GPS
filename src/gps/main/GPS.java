package gps.main;

import gps.utils.Task;
import gps.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GPS extends Utils implements CommandExecutor {
    private SpigotPlugin plugin;

    public GPS(SpigotPlugin plugin) {
        super(plugin);
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 1) {
                Player p = Bukkit.getPlayer(args[0]);
                if (p == null) {
                    sender.sendMessage(ChatColor.RED + "Игрок не в сети!");
                    return true;
                } else {
                    Player send = (Player) sender;
                    add(send);
                    send.getInventory().addItem(compass);
                    Task task = new Task(plugin, send, p);
                    Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, () -> {
                        if (contains(send)) {
                            int dist = (int) distance(task.p.getLocation(), task.sender.getLocation());
                            if (dist > 5) {
                                task.taskMessage(dist);
                            } else {
                                task.end();
                            }
                        }
                    }, 20L, 20L);
                    return true;
                }
            }
            sender.sendMessage(ChatColor.RED + "Вы ввели команду не по форме!");
            return true;
        } else {
            sender.sendMessage(ChatColor.RED + "Нет прав!");
            return true;
        }
    }
}