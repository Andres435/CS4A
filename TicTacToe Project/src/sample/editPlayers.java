package sample;

import Database.DatabaseManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class editPlayers implements Initializable
{
    @FXML private TableView<Player> fullTable;
    @FXML private TableColumn<Player, String> username;
    @FXML private TableColumn<Player, String> password;
    @FXML private TableColumn<Player, Integer> ties;
    @FXML private TableColumn<Player, Integer> wins;
    @FXML private TableColumn<Player, Integer> loss;
    @FXML private TableColumn<Player, String> firstname;
    @FXML private TableColumn<Player, String> lastname;
    DatabaseManager database = DatabaseManager.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        //initializes each property to associate with, then allows to be edited and changed in it
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        username.setCellFactory(TextFieldTableCell.forTableColumn());
        username.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Player, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Player, String> playerStringCellEditEvent)
            {
                Player player = playerStringCellEditEvent.getRowValue();
                player.setUsername(playerStringCellEditEvent.getNewValue());
                try {
                    database.update_username(player);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        password.setCellFactory(TextFieldTableCell.forTableColumn());
        password.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Player, String>>()
        {
            @Override
            public void handle(TableColumn.CellEditEvent<Player, String> playerStringCellEditEvent)
            {
                Player player = playerStringCellEditEvent.getRowValue();
                player.setPassword(playerStringCellEditEvent.getNewValue());
                try {
                    database.update_password(player);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });

        ties.setCellValueFactory(new PropertyValueFactory<>("ties"));
        ties.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        ties.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Player, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Player, Integer> playerIntegerCellEditEvent)
            {
                Player player = playerIntegerCellEditEvent.getRowValue();
                player.setTies(playerIntegerCellEditEvent.getNewValue());
                try {
                    database.update_ties(player);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        wins.setCellValueFactory(new PropertyValueFactory<>("wins"));
        wins.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        wins.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Player, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Player, Integer> playerIntegerCellEditEvent)
            {
                Player player = playerIntegerCellEditEvent.getRowValue();
                player.setWins(playerIntegerCellEditEvent.getNewValue());
                try {
                    database.update_wins(player);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        loss.setCellValueFactory(new PropertyValueFactory<>("losses"));
        loss.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        loss.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Player, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Player, Integer> playerIntegerCellEditEvent)
            {
                Player player = playerIntegerCellEditEvent.getRowValue();
                player.setLosses(playerIntegerCellEditEvent.getNewValue());
                try {
                    database.update_loss(player);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        firstname.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        firstname.setCellFactory(TextFieldTableCell.forTableColumn());
        firstname.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Player, String>>()
        {
            @Override
            public void handle(TableColumn.CellEditEvent<Player, String> playerStringCellEditEvent)
            {
                Player player = playerStringCellEditEvent.getRowValue();
                player.setFirstName(playerStringCellEditEvent.getNewValue());
                try {
                    database.update_firstname(player);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        lastname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastname.setCellFactory(TextFieldTableCell.forTableColumn());
        lastname.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Player, String>>()
        {
            @Override
            public void handle(TableColumn.CellEditEvent<Player, String> playerStringCellEditEvent)
            {
                Player player = playerStringCellEditEvent.getRowValue();
                player.setLastName(playerStringCellEditEvent.getNewValue());
                try {
                    database.update_lastname(player);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        fullTable.setItems(getPlayerData());
    }


    ObservableList<Player> getPlayerData()
    {
        ObservableList<Player> actives = FXCollections.observableArrayList();
        ArrayList<Player> player_data = database.getPlayers();
        int n = player_data.size();
        for(int i = 0; i < n; ++i)
        {
            //set observable list to ints
            actives.add(player_data.get(i));
        }
        return actives;
    }
}
