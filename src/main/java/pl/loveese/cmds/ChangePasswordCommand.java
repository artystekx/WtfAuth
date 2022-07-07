package pl.loveese.cmds;

import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.loveese.AuthLo;
import pl.loveese.events.onJoin;
import pl.loveese.playerdata.PlayerData;

public class ChangePasswordCommand implements CommandExecutor {

    AuthLo plugin;
    PlayerData pd;

    public ChangePasswordCommand(AuthLo m) {
        plugin = m;
        m.getCommand("changepassword").setExecutor(this);

        pd = PlayerData.getInstance();
    }

    @SuppressWarnings("static-access")
    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String lab, String[] args) {
        Player p = (Player) sender;
        UUID uuid = p.getUniqueId();

        if(onJoin.loggetIn.get(uuid) == true) {
            if(args.length == 3) {
                String old = args[0];
                String new1 = args[1];
                String new2 = args[2];
                String actualPass = pd.getData().getString(uuid + ".pass");

                if(old.equals(actualPass)) {
                    if(new1.equals(new2)) {
                        pd.getData().set(uuid + ".pass", new2);
                        pd.saveData();

                        p.sendMessage("§ePomyslnie zmieniles haslo!");
                    } else {
                        p.kickPlayer("§eTwoje hasla sie nie zgadzaja!");
                    }
                } else {
                    p.sendMessage("§eTwoje stare haslo sie nie zgadza!");
                }
            } else {
                p.sendMessage("§ePoprawne uzycie: /changepassword starehaslo nowehaslo nowehaslo");
            }
        } else {
            p.sendMessage("§eAby zmienic haslo musisz byc zalogowanym!");
        }

        return false;
    }
}
