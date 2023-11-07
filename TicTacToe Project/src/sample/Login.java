package sample;

import Database.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Login
{
    DatabaseManager database = DatabaseManager.getInstance();
    ControllerObserver controller = ControllerObserver.getInstance();
    @FXML private TextField username;
    @FXML private TextField password;

    private String user;
    private String pass;

    public void setUsername()
    {
        user = username.getText();
    }

    public void setPassword()
    {
        pass = password.getText();
    }

    public void login(ActionEvent actionEvent) throws SQLException
    {
        setUsername();
        setPassword();
        ArrayList<Player> players = database.getPlayers();
        int n = players.size();
        Player player = new Player();
        for(int i = 0; i < n; ++i)
        {
            player = players.get(i);
            if((player.getUsername().equals(user)) && (player.getPassword().equals(pass)))
            {
                controller.setPlayer(player);
                System.out.println("Login Successful");
                i = n;
            }
            else
            {
                System.out.println("Try Again");
            }
        }
    }

    public void create_account() throws IOException
    {
        Stage stage = new Stage();
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("/Scenes/Create_Account.fxml"));
        Parent root = firstLoader.load();
        Scene scene = new Scene(root, 259, 204);
        stage.setScene(scene);
        stage.show();
    }
}
