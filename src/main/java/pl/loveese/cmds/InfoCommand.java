package pl.loveese.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import pl.loveese.WtfAuth;

public class InfoCommand implements CommandExecutor {

    WtfAuth plugin;

    public InfoCommand(WtfAuth m) {
        plugin = m;
        m.getCommand("info").setExecutor(this);
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player p = (Player) sender;

        p.sendTitle("§cWtfAuth", "§eInfo");
        p.sendMessage(" ");
        p.sendMessage("§cWtfAuth 1.0-SNAPSHOT");
        p.sendMessage("§cAuthor: loveese");
        p.sendMessage("§cDownload: spigotmc.org");
        p.sendMessage("§cDiscord: discord.loveese.wtf");
        p.sendMessage("§cThank you for using this plugin §d<3");
        p.sendMessage(" ");
        return false;
    }
}
