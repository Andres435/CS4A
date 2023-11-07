package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class adminFunctions
{

    public void editPlayers(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("/Scenes/editPlayers.fxml"));
        Parent root = firstLoader.load();
        Scene scene = new Scene(root, 620, 320);
        stage.setScene(scene);
        stage.show();
    }

    public void editGames(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("/Scenes/editGames.fxml"));
        Parent root = firstLoader.load();
        Scene scene = new Scene(root, 620, 320);
        stage.setScene(scene);
        stage.show();
    }
}
