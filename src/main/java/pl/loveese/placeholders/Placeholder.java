package pl.loveese.placeholders;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pl.loveese.data.PlayerData;

public class Placeholder extends PlaceholderExpansion {

    PlayerData sd;

    /*
    The identifier, shouldn't contain any _ or %
     */
    public String getIdentifier() {
        return "wtfauth";
    }

    public String getPlugin() {
        return "WtfAuth";
    }


    /*
     The author of the Placeholder
     This cannot be null
     */
    public String getAuthor() {
        return "loveese";
    }

    /*
     Same with #getAuthor() but for versioon
     This cannot be null
     */

    public String getVersion() {
        return "1.0-BETA";
    }

    /*
    Use this method to setup placeholders
    This is somewhat similar to EZPlaceholderhook
     */
    public String onPlaceholderRequest(Player player, String identifier) {
        /*
         %tutorial_onlines%
         Returns the number of online players
          */
        if(identifier.equalsIgnoreCase("all")){
            return String.valueOf(Bukkit.getOnlinePlayers().size());
        }

        /*
        Check if the player is online,
        You should do this before doing anything regarding players
         */
        if(player == null){
            return "";
        }

        /*
        %tutorial_name%
        Returns the player name
         */
        if(identifier.equalsIgnoreCase("nazwa")){
            return player.getName();
        }



        return null;
    }
}
