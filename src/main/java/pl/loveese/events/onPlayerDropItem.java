package pl.loveese.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import pl.loveese.WtfAuth;

import java.util.UUID;

public class onPlayerDropItem implements Listener {

    WtfAuth plugin;

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent e) {
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();

        if(onJoin.loggetIn.get(uuid) == false) {
            e.setCancelled(true);
        }
    }
}
