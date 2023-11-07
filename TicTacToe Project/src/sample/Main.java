package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.Objects;

public class Main extends Application
{
    @Override
    public void start(Stage splash) throws Exception
    {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Scenes/splash.fxml")));
        Scene scene = new Scene(root, 600, 450);
        scene.getStylesheets().add("/Scenes/Stylesheet.css");
        splash.getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("/Images/Icon.jpg"))));
        splash.setTitle("Tic Tac Toe");
        splash.setScene(scene);
        splash.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
