package Pubsub.subscriber;

import Pubsub.message.Message;
import Pubsub.service.PubSubService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public abstract class Subscriber {
    // Store all messages received by the subscriber
    private List<Message> subscriberMessages = new ArrayList<Message>();
    private Socket socket;
    private String name;
    protected final DataInputStream in;
    protected final DataOutputStream out;

    public Subscriber(Socket socket, String name, DataInputStream in, DataOutputStream out) {
        this.socket = socket;
        this.name = name;
        this.in = in;
        this.out = out;
    }
    public List<Message> getSubscriberMessages () {
        return subscriberMessages;
    }

    public void setSubscriberMessages(List<Message> subscriberMessages) {
        this.subscriberMessages = subscriberMessages;
    }

    // Add subscriber with PubSubService for a topic
    public abstract void addSubscriber(String topic, PubSubService pubSubService);

    // Unsubscribe subscriber with PubSubService for a topic
    public abstract void unSubscribe(String topic, PubSubService pubSubService);

    // Request for messages related to a topic from PubSubService
    public abstract void getMessagesForSubscriberOfTopic(String topic, PubSubService pubSubService);

    // Print all messages received by the subscriber
    public void printMessages() {
        for(Message message : subscriberMessages) {
            System.out.println("MessageTopic -> " + message.getTopic());
        }
    }
}
