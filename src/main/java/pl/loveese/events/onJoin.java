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
import pl.loveese.WtfAuth;

public class onJoin implements Listener {

    WtfAuth plugin;

    public static Map<UUID, Boolean> loggetIn = new HashMap<UUID, Boolean>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();

        loggetIn.put(uuid, false);

        p.sendTitle(plugin.getConfig().getString("Command.welcometitle").replace("&", "§"), plugin.getConfig().getString("Command.welcomesubtitle").replace("&", "§"));
        p.sendMessage(" ");
        p.sendMessage(plugin.getConfig().getString("Command.welcomee").replace("&", "§"));
        p.sendMessage(" ");

        e.setJoinMessage(plugin.getConfig().getString("Message.join").replace("&", "§"));
    }
}
