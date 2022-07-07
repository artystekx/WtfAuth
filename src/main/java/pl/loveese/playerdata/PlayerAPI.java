package pl.loveese.playerdata;

public class PlayerAPI {

    private static PlayerData pd;

    static {
        pd = PlayerData.getInstance();
    }

}
