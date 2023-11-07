package Observer;

public interface Subject
{
    //interface to add, delete, and update observers

    public void register(Observer o);
    public void unregister(Observer o);
    public void notifyObserverImagePlayer1();
    public void notifyObserverImagePlayer2();
    public void notifyObserverInet();
    public void notifyObserverPlayer();
}
