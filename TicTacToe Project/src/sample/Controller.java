package sample;

import Database.DatabaseManager;
import Server.Client;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

public class Controller
{
    // Player turn variable
    public static boolean switchPlayer = true;
    ControllerObserver controller = ControllerObserver.getInstance();

    // Default Images for the players
    private Image player1 = new Image(Objects.requireNonNull(getClass().getResource("/Images/playerX.png")).toExternalForm());
    private Image player2 = new Image(Objects.requireNonNull(getClass().getResource("/Images/playerO.png")).toExternalForm());

    // Use of Singleton to make one TicTacToe game and one to carry variables across controllers
    private final TicTacToe game = TicTacToe.getInstance();
    private Player first_player = new Player();
    private final Player second_player = new Player("Bot", "N/A", "N/A", "N/A");
    DatabaseManager database = DatabaseManager.getInstance();
    //Initializes the client according to whether its local host or multiplayer
    Client player = new Client();
    private final AI ai = new AI();
    // Variable that shows the players current score
    @FXML private Label player1win;
    @FXML private Label player2win;

    // Images IDs
    @FXML private ImageView image1;
    @FXML private ImageView image2;
    @FXML private ImageView image3;
    @FXML private ImageView image4;
    @FXML private ImageView image5;
    @FXML private ImageView image6;
    @FXML private ImageView image7;
    @FXML private ImageView image8;
    @FXML private ImageView image9;

    // Variable that checks if the slot is empty
    private boolean empty1 = true;
    private boolean empty2 = true;
    private boolean empty3 = true;
    private boolean empty4 = true;
    private boolean empty5 = true;
    private boolean empty6 = true;
    private boolean empty7 = true;
    private boolean empty8 = true;
    private boolean empty9 = true;

    @FXML
    public void initialize()
    {
        first_player.setUsername("Anon");
    }

    private final Game new_game = new Game(getTime(), first_player.getUsername(), first_player.getUsername(), second_player.getUsername());

    @FXML void pressBtn1(MouseEvent event) throws SQLException {
        if (empty1)
        {
            game.checkBox(0, 0, switchPlayer);
            database.add_move(new Move(new_game.getGameID(),current_player(), 0,0,getTime()));
            empty1 = printShape(event, image1);
            generalBtn();
        }
    }

    @FXML void pressBtn2(MouseEvent event) throws SQLException {
        if (empty2) {
            game.checkBox(0, 1, switchPlayer);
            database.add_move(new Move(new_game.getGameID(),current_player(), 0,1,getTime()));
            empty2 = printShape(event, image2);
            generalBtn();
        }
    }

    @FXML void pressBtn3(MouseEvent event) throws SQLException {
        if (empty3) {
            game.checkBox(0, 2, switchPlayer);
            database.add_move(new Move(new_game.getGameID(),current_player(), 0,2,getTime()));
            empty3 = printShape(event, image3);
            generalBtn();
        }
    }

    @FXML void pressBtn4(MouseEvent event) throws SQLException {
        if (empty4) {
            game.checkBox(1, 0, switchPlayer);
            database.add_move(new Move(new_game.getGameID(),current_player(), 1,0,getTime()));
            empty4 = printShape(event, image4);
            generalBtn();
        }
    }

    @FXML void pressBtn5(MouseEvent event) throws SQLException {
        if (empty5) {
            game.checkBox(1, 1, switchPlayer);
            database.add_move(new Move(new_game.getGameID(),current_player(), 1,1,getTime()));
            empty5 = printShape(event, image5);
            generalBtn();
        }
    }

    @FXML void pressBtn6(MouseEvent event) throws SQLException {
        if (empty6) {
            game.checkBox(1, 2, switchPlayer);
            database.add_move(new Move(new_game.getGameID(),current_player(), 1,2,getTime()));
            empty6 = printShape(event, image6);
            generalBtn();
        }
    }

    @FXML void pressBtn7(MouseEvent event) throws SQLException {
        if (empty7) {
            game.checkBox(2, 0, switchPlayer);
            database.add_move(new Move(new_game.getGameID(),current_player(), 2,0,getTime()));
            empty7 = printShape(event, image7);
            generalBtn();
        }
    }

    @FXML void pressBtn8(MouseEvent event) throws SQLException {
        if (empty8) {
            game.checkBox(2, 1, switchPlayer);
            database.add_move(new Move(new_game.getGameID(),current_player(), 2,1,getTime()));
            empty8 = printShape(event, image8);
            generalBtn();
        }
    }

    @FXML void pressBtn9(MouseEvent event) throws SQLException {
        if (empty9) {
            game.checkBox(2, 2, switchPlayer);
            database.add_move(new Move(new_game.getGameID(),current_player(), 2,2,getTime()));
            empty9 = printShape(event, image9);
            generalBtn();
        }
    }

    void generalBtn() throws SQLException {
        if (game.checkWin() != 0 || game.isFull()) {
            checkScore();
            new_game();
        }
        game.printBoard();
        if (!switchPlayer)
            if (!controller.getMode())
                update();
    }

    // Switch the shape of player 1 based on radio selected in menu
    public void switchPlayer1() throws IOException {
        Stage playerShape = new Stage();
        playerShape.setTitle("Player Shape");
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("/Scenes/PlayerShapes1.fxml"));
        Parent root = firstLoader.load();
        Scene scene = new Scene(root, 543, 160);
        playerShape.getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("/Images/Icon.jpg"))));
        playerShape.setScene(scene);
        playerShape.show();

        playerShape.setOnCloseRequest(windowEvent -> player1 = controller.getPlayerImage1());
    }

    // Switch the shape of player 2 based on radio selected in menu
    public void switchPlayer2() throws IOException {
        Stage playerShape = new Stage();
        playerShape.setTitle("Player Shape");
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("/Scenes/PlayerShapes2.fxml"));
        Parent root = firstLoader.load();
        Scene scene = new Scene(root, 543, 160);
        playerShape.getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("/Images/Icon.jpg"))));
        playerShape.setScene(scene);
        playerShape.show();

        playerShape.setOnCloseRequest(windowEvent -> player2 = controller.getPlayerImage2());
    }

    // Resize image of the player shape and place it on the rectangle
    public boolean printShape(MouseEvent event, ImageView image) {
        if (event.getButton() == MouseButton.PRIMARY) {
            if (switchPlayer) {
                image.setImage(player1);
                image.setFitHeight(image1.getFitWidth());
                image.setFitHeight(image1.getFitHeight());
                image.setPreserveRatio(false);
                switchPlayer = false;
            } else {
                image.setImage(player2);
                image.setFitHeight(image1.getFitWidth());
                image.setFitHeight(image1.getFitHeight());
                image.setPreserveRatio(false);
                switchPlayer = true;
            }
        }
        return false;
    }

    // Sets the all the images to clear the game board for new game.
    private void clearGame() {
        image1.setImage(null);
        empty1 = true;

        image2.setImage(null);
        empty2 = true;

        image3.setImage(null);
        empty3 = true;

        image4.setImage(null);
        empty4 = true;

        image5.setImage(null);
        empty5 = true;

        image6.setImage(null);
        empty6 = true;

        image7.setImage(null);
        empty7 = true;

        image8.setImage(null);
        empty8 = true;

        image9.setImage(null);
        empty9 = true;
    }
    // Updates current score between the players
    public void checkScore() throws SQLException {
        String screenText;
        String text;

        if (game.checkWin() < 0)
        {
            if(database.getPlayers().contains(second_player))
            {
                database.add_win(second_player);
            }
            database.add_loss(first_player);
            new_game.setWinner(second_player.getUsername());
            text = player2win.getText();
            player2win.setText(text + "X");
            screenText = "Player 2 Won";
        }
        else if (game.checkWin() > 0)
        {
            if(database.getPlayers().contains(first_player))
            {
                database.add_win(first_player);
                database.add_loss(second_player);
            }
            new_game.setWinner(first_player.getUsername());
            text = player1win.getText();
            player1win.setText(text + "X");
            screenText = "Player 1 won";
        }
        else
        {
            database.add_tie(first_player);
            database.add_tie(second_player);
            new_game.setWinner("Tie");
            screenText = "Tie";
        }

        Win win = new Win();
        win.winWindow(screenText);
    }

    public void new_game() throws SQLException {
        new_game.setEnd_time(getTime());
        new_game.setPlayer1(first_player.getUsername());
        new_game.setWho_created(first_player.getUsername());
        game.clearBoard();
        clearGame();
        database.add_game(new_game);
        //new_game.clear_game();
        new_game.setStart_time(getTime());
        new_game.setGameID(new Random().nextInt(100000));
        new_game.setWho_created(first_player.getUsername());
        new_game.setPlayer1(first_player.getUsername());
        new_game.setPlayer2(second_player.getUsername());
    }

    @FXML public void newGameItemClicked() throws SQLException
    {
        new_game();
    }

    public void CpuTurn(int i, int j) throws SQLException {
        int position = j + (i * 3);            //calculate which button cpu should press
        System.out.println("Position " + position);
        MouseEvent fakeEvent = new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, MouseButton.PRIMARY, 0, true, true, true, true, true, true, true, true, true, true, null);

        switch (position) {
            case 0 -> pressBtn1(fakeEvent);
            case 1 -> pressBtn2(fakeEvent);
            case 2 -> pressBtn3(fakeEvent);
            case 3 -> pressBtn4(fakeEvent);
            case 4 -> pressBtn5(fakeEvent);
            case 5 -> pressBtn6(fakeEvent);
            case 6 -> pressBtn7(fakeEvent);
            case 7 -> pressBtn8(fakeEvent);
            case 8 -> pressBtn9(fakeEvent);
        }
    }

    public void update() throws SQLException {
        int[] coordinates = ai.makeMove();
        CpuTurn(coordinates[0], coordinates[1]);
    }

    public void openHelpMenu() { new HelpMenu(); }

    @FXML public void closeApp() {
        if(controller.getMode())
            player.sendMessage(player.getUserName() + " # " +"logout");
        Platform.exit();
    }

    public void chatWindow() {
        player.assignUserName("Anonymous");
        player.PlayerChat();
    }
  
  public void openLoginMenu() throws IOException
    {
        Stage playerShape = new Stage();
        FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("/Scenes/login.fxml"));
        Parent root = firstLoader.load();
        Scene scene = new Scene(root, 254, 120);
        playerShape.getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("/Images/Icon.jpg"))));
        playerShape.setTitle("Login");
        playerShape.setScene(scene);
        playerShape.show();

        playerShape.setOnCloseRequest(windowEvent -> first_player = controller.getUser());
    }

    private String getTime()
    {
        String time;
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        time = year + "/" + month + "/" + day + "-" + hour + ":" + minute + ":" + second;
        return time;
    }

    private String current_player()
    {
        if(switchPlayer == true)
        {
            return first_player.getUsername();
        }
        else
            return second_player.getUsername();
    }
}
