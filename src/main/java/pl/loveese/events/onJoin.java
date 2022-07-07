package pl.loveese.events;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.loveese.data.SpawnJoinData;

public class onJoin implements Listener {

    SpawnJoinData sd;

    public static Map<UUID, Boolean> loggetIn = new HashMap<UUID, Boolean>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();

        loggetIn.put(uuid, false);
        double x = sd.getData().getDouble("spawn.x");
        double y = sd.getData().getDouble("spawn.y");
        double z = sd.getData().getDouble("spawn.z");

        String world = sd.getData().getString("spawn.world");

        p.teleport(new Location(Bukkit.getWorld(world), x, y ,z));
    }
}
