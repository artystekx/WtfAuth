package pl.loveese.cmds;

import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.loveese.WtfAuth;
import pl.loveese.events.onJoin;
import pl.loveese.data.PlayerData;

public class RegisterCommand implements CommandExecutor {

    WtfAuth plugin;
    PlayerData pd;

    public RegisterCommand(WtfAuth m) {
        plugin = m;
        m.getCommand("register").setExecutor(this);

        pd = PlayerData.getInstance();
    }

    @SuppressWarnings("static-access")
    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String lab, String[] args) {
        Player p = (Player) sender;
        UUID uuid = p.getUniqueId();

        if(pd.getData().getString(uuid + ".pass") == null) {
            if(args.length == 2) {
                String pass1 = args[0];

                if(args[0].equalsIgnoreCase(args[1])) {
                    pd.getData().set(uuid + ".pass", pass1);
                    pd.saveData();

                    onJoin.loggetIn.put(uuid, true);

                    p.sendMessage(plugin.getConfig().getString("Command.successregister").replace("&", "§"));
                } else {
                    p.sendMessage(plugin.getConfig().getString("Command.passworderror").replace("&", "§"));
                }
            } else {
                p.sendMessage(plugin.getConfig().getString("Command.usageregister").replace("&", "§"));
            }
        } else {
            p.sendMessage(plugin.getConfig().getString("Command.playerregister").replace("&", "§"));
        }

        return false;
    }
}

