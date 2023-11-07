package sample;

import javafx.beans.property.SimpleStringProperty;

public class lobby_games
{
    private final SimpleStringProperty gameID = new SimpleStringProperty("");

    public String getGameID() {
        return gameID.get();
    }

    public void setGameID(String gameID) {
        this.gameID.set(gameID);
    }

    public String getPeople() {
        return people.get();
    }


    public void setPeople(String people) {
        this.people.set(people);
    }

    private final SimpleStringProperty people = new SimpleStringProperty("");

    public lobby_games()
    {
        this("","");
    }

    public lobby_games(String ID, String player_amount)
    {
        setGameID(ID);
        setPeople(player_amount);
    }
}
