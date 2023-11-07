package Pubsub.message;

public class MoveMessage extends Message{
    private int position;

    MoveMessage(int position) {
        setTopic("Move Message");
        this.position = position;
    }
}
