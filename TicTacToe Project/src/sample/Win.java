package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import java.io.IOException;


public class Win {

    @FXML private Label winStatement;

    public void winWindow(String winText) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Scenes/winWindow.fxml"));
            Parent root = loader.load();

            Stage winWindow = new Stage();
            winWindow.setScene(new Scene(root));

            Win controller = loader.getController();
            controller.winStatement.setText(winText);

            winWindow.setX(662); // offset x value for window start point
            winWindow.setY(185); // offset y value for window start point

            winWindow.initStyle(StageStyle.UNDECORATED);    // Will not have close bar
            winWindow.show();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @FXML public void closeWindow(MouseEvent event){
        Window window =   ((Node)(event.getSource())).getScene().getWindow();
        if (window instanceof Stage){
            ((Stage) window).close();
        }
    }
}
