package Observer;

import sample.Player;
import javafx.scene.image.Image;
import java.net.InetAddress;

public interface Observer
{
    // Observers update method is called when subject changes
    public void updatePlayer1(Image player1);

    public void updatePlayer2(Image player2);

    public void update(InetAddress ipaddress);

    public void update(Player player);
}
