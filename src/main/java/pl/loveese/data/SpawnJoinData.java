package pl.loveese.data;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;
import pl.loveese.WtfAuth;

public class SpawnJoinData {

    static  SpawnJoinData instance;
    Plugin p;
    FileConfiguration data;
    public static File rfile;

    static {
        instance = new SpawnJoinData();
    }

    public static SpawnJoinData getInstance() {
        return instance;
    }

    public void setup(WtfAuth p) {
        if(!p.getDataFolder().exists()) {
            p.getDataFolder().mkdir();
        }

        File path = new File(p.getDataFolder() + File.separator + "/data");
        rfile = new File(path, String.valueOf(File.separatorChar + "spawn.yml"));
        if(!rfile.exists()) {
            try {
                path.mkdirs();
                rfile.createNewFile();
            } catch(IOException e) {
                Bukkit.getServer().getLogger().severe(ChatColor.RED + "spawn.yml");
            }
        }
        data = YamlConfiguration.loadConfiguration(rfile);
    }

    public FileConfiguration getData() {
        return data;
    }

    public void saveData() {
        try {
            data.save(rfile);
        } catch(IOException e) {
            Bukkit.getServer().getLogger().severe(ChatColor.YELLOW + "try again");
        }
    }

    public void reloadData() {
        data = YamlConfiguration.loadConfiguration(rfile);
    }
}