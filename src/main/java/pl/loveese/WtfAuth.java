package pl.loveese;

import org.bukkit.plugin.java.JavaPlugin;

import pl.loveese.cmds.*;
import pl.loveese.data.SpawnJoinData;
import pl.loveese.events.onJoin;
import pl.loveese.events.onMove;
import pl.loveese.events.onPlayerDropItem;
import pl.loveese.events.onPlayerPickupItem;
import pl.loveese.data.PlayerData;

public class WtfAuth extends JavaPlugin {

    PlayerData pd;
    SpawnJoinData sd;

    public WtfAuth() {
        pd = PlayerData.getInstance();
        sd = SpawnJoinData.getInstance();
    }

    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        pd.setup(this);
        sd.setup(this);

        new LoginCommand(this);
        new RegisterCommand(this);
        new ChangePasswordCommand(this);
        new InfoCommand(this);
        new WtfAuthAdminCommand(this);

        getServer().getPluginManager().registerEvents(new onJoin(), this);
        getServer().getPluginManager().registerEvents(new onMove(), this);
        getServer().getPluginManager().registerEvents(new onPlayerDropItem(), this);
        getServer().getPluginManager().registerEvents(new onPlayerPickupItem(), this);
    }

}
