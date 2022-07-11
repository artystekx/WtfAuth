package pl.loveese.events;

import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import pl.loveese.WtfAuth;

public class onMove implements Listener {

    WtfAuth plugin;

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();

        if(onJoin.loggetIn.get(uuid) == false) {
            e.setCancelled(true);
            p.sendMessage(plugin.getConfig().getString("Command.onmove"));
        }
    }
}

