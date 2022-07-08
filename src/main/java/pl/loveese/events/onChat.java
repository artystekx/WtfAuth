package pl.loveese.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import pl.loveese.WtfAuth;

import java.util.UUID;

public class onChat implements Listener {

    WtfAuth plugin;

    @EventHandler
    public void onChat(PlayerChatEvent e) {
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();

        if(onJoin.loggetIn.get(uuid) == false) {
            e.setCancelled(true);
            p.sendMessage(ChatColor.RED + plugin.getConfig().getString("Command.onchat"));
        }
    }
}
