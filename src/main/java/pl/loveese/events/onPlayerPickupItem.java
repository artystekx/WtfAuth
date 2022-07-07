package pl.loveese.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import pl.loveese.WtfAuth;

import java.util.UUID;

public class onPlayerPickupItem implements Listener {

    WtfAuth plugin;

    @EventHandler
    public void onPlayerPickupItem(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();

        if(onJoin.loggetIn.get(uuid) == false) {
            e.setCancelled(true);
        }
    }
}
