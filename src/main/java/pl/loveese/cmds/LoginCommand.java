package pl.loveese.cmds;

import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import pl.loveese.Main;
import pl.loveese.events.onJoin;
import pl.loveese.playerdata.PlayerData;

public class LoginCommand implements CommandExecutor {

    Main plugin;
    PlayerData pd;

    public LoginCommand(Main m) {
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

                        p.sendMessage("§eZostales zalogowany!");
                    } else {
                        p.kickPlayer("§eZle wpisales haslo! \n§7Sprobuj ponownie!");
                    }
                } else {
                    p.sendMessage("§eNie jestes zarejestrowany!");
                    p.sendMessage("§eUzyj komendy: §7/register haslo haslo");
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