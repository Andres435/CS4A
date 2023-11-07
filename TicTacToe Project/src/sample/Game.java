package sample;

import java.io.Serializable;
import java.sql.Time;
import java.util.Random;

public class Game implements Serializable
{
    private String start_time;
    private String end_time;
    private String who_created;
    private String player1;
    private String player2;
    private String winner;
    private int gameID;

    public Game() {}

    public Game(String start, String player, String first, String second)
    {
        start_time = start;
        who_created = player;
        player1 = first;
        player2 = second;
        setGameID(new Random().nextInt(100000));
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getWho_created() {
        return who_created;
    }

    public void setWho_created(String who_created) {
        this.who_created = who_created;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public void clear_game()
    {
        setStart_time("");
        setEnd_time("");
        setWho_created("");
        setPlayer1("");
        setPlayer2("");
        setWinner("");
        setGameID(0);
    }
}
