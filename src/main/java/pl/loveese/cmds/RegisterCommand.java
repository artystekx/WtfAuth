package pl.loveese.cmds;

import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import pl.loveese.Main;
import pl.loveese.events.onJoin;
import pl.loveese.playerdata.PlayerData;

public class RegisterCommand implements CommandExecutor {

    Main plugin;
    PlayerData pd;

    public RegisterCommand(Main m) {
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

                    p.sendMessage("§eZostales zarejestrowany w bazie danych");
                } else {
                    p.sendMessage("§cBlad! §eTe hasla sie nie zgadzaja");
                }
            } else {
                p.sendMessage("§7Uzycie: §e/register haslo haslo");
            }
        } else {
            p.sendMessage("§cBlad! §eJuz jestes zarejestrowany");
        }

        return false;
    }
}

