package pl.loveese.cmds;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import pl.loveese.WtfAuth;
import pl.loveese.data.SpawnJoinData;

public class WtfAuthAdminCommand implements CommandExecutor {

    SpawnJoinData sd;

    WtfAuth plugin;

    public WtfAuthAdminCommand(WtfAuth m) {
        plugin = m;
        m.getCommand("wtfauthadmin").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("setspawn")) {
                if (p.hasPermission("wtfauth.admin")) {
                    Location loc = p.getLocation();

                    double x = loc.getX();
                    double y = loc.getY();
                    double z = loc.getZ();

                    String world = loc.getWorld().getName();

                    sd.getData().set("spawn.x", x);
                    sd.getData().set("spawn.y", y);
                    sd.getData().set("spawn.z", z);
                    sd.getData().set("spawn.world", world);
                    sd.saveData();
                }
                }
            }
            return false;
        }
    }
