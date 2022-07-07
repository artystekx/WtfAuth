package pl.loveese.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import pl.loveese.AuthLo;

import java.util.UUID;

public class onPlayerCommand implements Listener {

    AuthLo plugin;

    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();

        if(onJoin.loggetIn.get(uuid) == false) {
            e.setCancelled(true);
            p.sendMessage(plugin.getConfig().getString("Command.nologin").replace("&", ""));
        }
    }
}
