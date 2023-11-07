package Observer;

import sample.Player;

import javafx.scene.image.Image;
import java.net.InetAddress;
import java.util.ArrayList;
//uses Subject interface to update all Observers
public class InfoGrabber implements Subject
{
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private Image player1;
    private Image player2;
    private InetAddress ipaddress;
    private Player player;

    @Override
    public void register(Observer o)
    {
        observers.add(o);
    }

    @Override
    public void unregister(Observer o)
    {
        int index = observers.indexOf(o);
        observers.remove(index);
    }

    @Override
    public void notifyObserverImagePlayer1()
    {
        //cycles through observers and notifies observers of change
        for(Observer observer : observers)
        {
            observer.updatePlayer1(player1);
        }
    }

    @Override
    public void notifyObserverImagePlayer2()
    {
        //cycles through observers and notifies observers of change
        for(Observer observer : observers)
        {
            observer.updatePlayer2(player2);
        }
    }

    @Override
    public void notifyObserverInet()
    {
        //cycles through observers and notifies observers of change
        for(Observer observer : observers)
        {
            observer.update(ipaddress);
        }
    }

    @Override
    public void notifyObserverPlayer()
    {
        //cycles through observers and notifies observers of change
        for(Observer observer : observers)
        {
            observer.update(player);
        }
    }

    //Changes values and notifies observers of changes
    public void setPlayer(Player player)
    {
        this.player = player;
        notifyObserverPlayer();
    }

    public void setImage1(Image image1)
    {
        this.player1 = image1;
        notifyObserverImagePlayer1();
    }

    public void setImage2(Image image1)
    {
        this.player2 = image1;
        notifyObserverImagePlayer2();
    }

    public void setIpaddress(InetAddress ip)
    {
        this.ipaddress = ip;
        notifyObserverInet();
    }
}
