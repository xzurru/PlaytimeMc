package zmod.playtimePlugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PlaytimePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("PlaytimePlugin on!");
    }

    @Override
    public void onDisable() {
        getLogger().info("PlaytimePlugin off!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("playtime")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;

                // Spielzeit des Spielers abrufen
                long playedTicks = player.getStatistic(org.bukkit.Statistic.PLAY_ONE_MINUTE);
                long secondsPlayed = playedTicks / 20; // 20 Ticks pro Sekunde

                long hours = secondsPlayed / 3600;
                long minutes = (secondsPlayed % 3600) / 60;
                long seconds = secondsPlayed % 60;

                player.sendMessage("§aYour Playtime: §b" + hours + " Hours, " + minutes + " Min, " + seconds + " Seconds.");
            } else {
                sender.sendMessage("only for players.");
            }
            return true;
        }
        return false;
    }
}
