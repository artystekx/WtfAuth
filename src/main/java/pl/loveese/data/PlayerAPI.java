package pl.loveese.data;

public class PlayerAPI {

    private static PlayerData pd;

    static {
        pd = PlayerData.getInstance();
    }

}
