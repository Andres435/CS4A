package Pubsub.message;

import java.io.ObjectOutputStream;

public class Message {
    private String topic;

    public Message(){}

    public String getTopic() {
        return this.topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

}
