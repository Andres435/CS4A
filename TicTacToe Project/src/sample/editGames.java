package sample;

import Database.DatabaseManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import java.io.IOException;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class editGames implements Initializable
{
    @FXML private TableView<Game> fullTable;
    @FXML private TableColumn<Game, String> starting;
    @FXML private TableColumn<Game, String> ending;
    @FXML private TableColumn<Game, String> creator;
    @FXML private TableColumn<Game, String> first_player;
    @FXML private TableColumn<Game, String> second_player;
    @FXML private TableColumn<Game, String> winning;
    @FXML private TableColumn<Game, Integer> gameSession;

    @FXML private TextField replayGameButton;
    DatabaseManager database = DatabaseManager.getInstance();
    ControllerObserver controller = ControllerObserver.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        starting.setCellValueFactory(new PropertyValueFactory<>("start_time"));
        starting.setCellFactory(TextFieldTableCell.forTableColumn());
        starting.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Game, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Game, String> gameStringCellEditEvent)
            {
                Game game = gameStringCellEditEvent.getRowValue();
                game.setStart_time(gameStringCellEditEvent.getNewValue());
                try {
                    database.update_startTime(game);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        ending.setCellValueFactory(new PropertyValueFactory<>("end_time"));
        ending.setCellFactory(TextFieldTableCell.forTableColumn());
        ending.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Game, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Game, String> gameStringCellEditEvent)
            {
                Game game = gameStringCellEditEvent.getRowValue();
                game.setEnd_time(gameStringCellEditEvent.getNewValue());
                try {
                    database.update_endTime(game);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        creator.setCellValueFactory(new PropertyValueFactory<>("who_created"));
        creator.setCellFactory(TextFieldTableCell.forTableColumn());
        creator.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Game, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Game, String> gameStringCellEditEvent)
            {
                Game game = gameStringCellEditEvent.getRowValue();
                game.setWho_created(gameStringCellEditEvent.getNewValue());
                try {
                    database.update_creator(game);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        first_player.setCellValueFactory(new PropertyValueFactory<>("player1"));
        first_player.setCellFactory(TextFieldTableCell.forTableColumn());
        first_player.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Game, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Game, String> gameStringCellEditEvent)
            {
                Game game = gameStringCellEditEvent.getRowValue();
                game.setPlayer1(gameStringCellEditEvent.getNewValue());
                try {
                    database.update_firstPlayer(game);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        second_player.setCellValueFactory(new PropertyValueFactory<>("player2"));
        second_player.setCellFactory(TextFieldTableCell.forTableColumn());
        second_player.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Game, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Game, String> gameStringCellEditEvent)
            {
                Game game = gameStringCellEditEvent.getRowValue();
                game.setPlayer2(gameStringCellEditEvent.getNewValue());
                try {
                    database.update_secondPlayer(game);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        winning.setCellValueFactory(new PropertyValueFactory<>("winner"));
        winning.setCellFactory(TextFieldTableCell.forTableColumn());
        winning.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Game, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Game, String> gameStringCellEditEvent)
            {
                Game game = gameStringCellEditEvent.getRowValue();
                game.setWinner(gameStringCellEditEvent.getNewValue());
                try {
                    database.update_winner_of_game(game);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        gameSession.setCellValueFactory(new PropertyValueFactory<>("gameID"));
        gameSession.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        gameSession.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Game, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Game, Integer> gameIntegerCellEditEvent)
            {
                Game game = gameIntegerCellEditEvent.getRowValue();
                game.setGameID(gameIntegerCellEditEvent.getNewValue());
                try {
                    database.update_gameID(game);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        fullTable.setItems(getPlayerData());
    }

    ObservableList<Game> getPlayerData()
    {
        ObservableList<Game> actives = FXCollections.observableArrayList();
        ArrayList<Game> game_data = database.getGames();
        int n = game_data.size();
        for(int i = 0; i < n; ++i)
        {
            //set observable list to ints
            actives.add(game_data.get(i));
        }
        return actives;
    }

    public void replayGame(ActionEvent actionEvent) throws IOException
    {

        controller.setReplayID(Integer.parseInt(replayGameButton.getText()));
        Stage stage = new Stage();
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("/Scenes/replay.fxml"));
        Parent root = firstLoader.load();
        Scene scene = new Scene(root, 610, 460);
        stage.setScene(scene);
        stage.show();
    }
}
