package Observer;

import javafx.scene.image.Image;
import sample.Player;

import java.net.InetAddress;

//Represents each Observer that is monitoring changes in the subject
public class InfoObserver implements Observer
{
    private Image player1;
    private Image player2;
    private InetAddress ipaddress;
    private Player player;
    //used as a counter
    private static int observerIDtracker = 0;
    //used to track observers
    private int observerID;
    private Subject controllerObserver;

    public InfoObserver(Subject controllerObserver)
    {
        //Store reference to the controllerObserver to make calls to its method
        this.controllerObserver = controllerObserver;
        //assign an obvserver ID and increment the static counter
        this.observerID = ++observerIDtracker;
        //Message notifies user of new observer
        System.out.println("New Observer " + this.observerID);
        //Add the observer to Subjects Arraylist
        controllerObserver.register(this);
    }

    @Override
    public void updatePlayer1(Image player)
    {
        this.player1 = player;
    }

    @Override
    public void updatePlayer2(Image player)
    {
        this.player2 = player;
    }

    @Override
    public void update(InetAddress ip)
    {
        this.ipaddress = ip;
    }

    @Override
    public void update(Player player)
    {
        this.player = player;
    }
}
