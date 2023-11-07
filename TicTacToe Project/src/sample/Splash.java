package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Objects;

public class Splash
{
    private final ControllerObserver controller = ControllerObserver.getInstance();

    @FXML
    public void singlePlayerBtn() throws IOException
    {
        controller.setIp(InetAddress.getByName("localhost"));
        controller.setMode(false);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Scenes/SinglePlayer.fxml"));
        Parent root = loader.load();
        Controller control = loader.getController();

        Stage singlePlayer = new Stage();
        singlePlayer.setScene(new Scene(root, 600, 450));
        singlePlayer.getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("/Images/Icon.jpg"))));
        singlePlayer.setTitle("Tic Tac Toe");
        singlePlayer.show();

        singlePlayer.setOnCloseRequest(windowEvent -> control.closeApp());
    }

    @FXML
    void multiplayerBtn() throws Exception
    {
        //this ip address should be the address of the server and should be changed as such
        controller.setIp(InetAddress.getByName("68.5.129.181"));
        controller.setMode(true);
        callStage();
    }

    @FXML
    void lanBtn() throws Exception
    {
        controller.setIp(InetAddress.getByName("localhost"));
        controller.setMode(true);
        callStage();
    }

    @FXML void callLobby() throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Scenes/Lobby.fxml"));
        Parent root = loader.load();
        controller.setMode(true);
        controller.setSearch(true);
        Lobby lobbyController = loader.getController();
  
        Stage lobby = new Stage();
        lobby.setScene(new Scene(root, 600, 450));
        lobby.getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("/Images/Icon.jpg"))));
        lobby.setTitle("Tic Tac Toe");
        lobby.show();
        lobbyController.update();
    }

    void callStage() throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Scenes/Multiplayer.fxml"));
        Parent root = loader.load();
        TicTacToeClient control = loader.getController();
        control.setMultiplayerType("Random");
        control.startup();

        Stage lan = new Stage();
        lan.setScene(new Scene(root, 600, 450));
        lan.getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("/Images/Icon.jpg"))));
        lan.setTitle("Tic Tac Toe");
        lan.show();

        lan.setOnCloseRequest(windowEvent -> control.closeApp());
    }

    public void login() throws IOException
    {
        Stage playerShape = new Stage();
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("/Scenes/login.fxml"));
        Parent root = firstLoader.load();
        Scene scene = new Scene(root, 254, 120);
        playerShape.getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("/Images/Icon.jpg"))));
        playerShape.setTitle("Login");
        playerShape.setScene(scene);
        playerShape.show();
    }

    public void createAccount() throws IOException
    {
        Stage stage = new Stage();
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("/Scenes/Create_Account.fxml"));
        Parent root = firstLoader.load();
        Scene scene = new Scene(root, 259, 204);

        stage.getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("/Images/Icon.jpg"))));
        stage.setTitle("Create Account");
        stage.setScene(scene);
        stage.show();
    }

    public void closeWindow(javafx.scene.input.MouseEvent event)
    {
        Window window =   ((Node)(event.getSource())).getScene().getWindow();
        if (window instanceof Stage){
            ((Stage) window).close();
        }
    }

    public void adminActions(ActionEvent actionEvent) throws IOException
    {
        Stage stage = new Stage();
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("/Scenes/adminFunctions.fxml"));
        Parent root = firstLoader.load();
        Scene scene = new Scene(root, 190, 170);
        stage.setScene(scene);
        stage.show();
    }
}
