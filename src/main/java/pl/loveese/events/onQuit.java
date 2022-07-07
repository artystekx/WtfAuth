package pl.loveese.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import pl.loveese.WtfAuth;

public class onQuit implements Listener {

    WtfAuth plugin;

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        e.setQuitMessage(plugin.getConfig().getString("Message.quit").replace("&", "§"));
    }
}
