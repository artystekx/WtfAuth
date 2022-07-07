package pl.loveese;

import org.bukkit.plugin.java.JavaPlugin;

import pl.loveese.cmds.ChangePasswordCommand;
import pl.loveese.cmds.LoginCommand;
import pl.loveese.cmds.RegisterCommand;
import pl.loveese.events.onJoin;
import pl.loveese.events.onMove;
import pl.loveese.events.onPlayerCommand;
import pl.loveese.playerdata.PlayerData;

public class WtfAuth extends JavaPlugin {

    PlayerData pd;

    public WtfAuth() {
        pd = PlayerData.getInstance();
    }

    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        pd.setup(this);

        new LoginCommand(this);
        new RegisterCommand(this);
        new ChangePasswordCommand(this);

        getServer().getPluginManager().registerEvents(new onJoin(), this);
        getServer().getPluginManager().registerEvents(new onMove(), this);
        getServer().getPluginManager().registerEvents(new onPlayerCommand(), this);
    }

}
