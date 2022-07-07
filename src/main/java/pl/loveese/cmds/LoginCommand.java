package pl.loveese.cmds;

import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import pl.loveese.AuthLo;
import pl.loveese.events.onJoin;
import pl.loveese.playerdata.PlayerData;

public class LoginCommand implements CommandExecutor {

    AuthLo plugin;
    PlayerData pd;

    public LoginCommand(AuthLo m) {
        plugin = m;
        m.getCommand("login").setExecutor(this);

        pd = PlayerData.getInstance();
    }

    @SuppressWarnings("static-access")
    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String lab, String[] args) {
        Player p = (Player) sender;
        UUID uuid = p.getUniqueId();

        if(onJoin.loggetIn.get(uuid) == false) {
            if(args.length == 1) {
                if(pd.getData().getString(uuid + ".pass") != null) {
                    String pass = args[0];
                    String actualPass = pd.getData().getString(uuid + ".pass");

                    if(pass.equals(actualPass))	{
                        onJoin.loggetIn.put(uuid, true);

                        p.sendMessage(plugin.getConfig().getString("Command.loginsucces").replace("&", ""));
                    } else {
                        p.kickPlayer(plugin.getConfig().getString("Command.errorpassword").replace("&", ""));
                    }
                } else {
                    p.sendMessage("&eUzyj komendy: §7/register haslo haslo /n&eNie jestes zarejestrowany!");
                }
            } else {
                p.sendMessage("§eUzycie: §7/login haslo");
            }
        } else {
            p.sendMessage("§eZostales pomyslnie zalogowany!");
        }
        return false;
    }
}