package sample;

import javafx.scene.image.Image;

import java.net.InetAddress;

public class ControllerObserver
{
    private Image playerImage1;//= new Image("Pics/player0.png");
    private Image playerImage2; //= new Image("Pics/playerX.png");
    private InetAddress ip = null;
    private Player player;

    public int getReplayID() {
        return replayID;
    }

    public void setReplayID(int replayID) {
        this.replayID = replayID;
    }

    private int replayID;

    private boolean mode;
    private boolean search = false;

    private static final ControllerObserver instance = new ControllerObserver();

    private ControllerObserver() {}

    public static ControllerObserver getInstance()
    {
        return instance;
    }

    //get image of players 1 and 2;
    public Image getPlayerImage1()
    {
        return playerImage1;
    }

    public Image getPlayerImage2()
    {
        return playerImage2;
    }

    //get IP address
    public InetAddress getIp(){return ip;}

    //get the player;
    public Player getUser(){return player;}

    public void setPlayerImage1(Image image)
    {
       playerImage1 = image;
    }

    public void setPlayerImage2(Image image) { playerImage2 = image; }

    public void setIp(InetAddress ipaddress) {ip = ipaddress; }

    public void setPlayer(Player user) {player = user;}

    public void setMode(boolean mode) { this.mode = mode;} // false = single player, true = multiplayer

    public boolean getMode() {return mode;};

    public void setSearch(boolean search) { this.search = search;}

    public boolean getSearch() {return search;}
}