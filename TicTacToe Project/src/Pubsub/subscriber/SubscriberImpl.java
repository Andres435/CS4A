package Pubsub.subscriber;

import Pubsub.service.PubSubService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class SubscriberImpl extends Subscriber{

    public SubscriberImpl(Socket socket, String name, DataInputStream in, DataOutputStream out) {
        super(socket, name, in, out);
    }

    // Add subscriber with PubSubService for a topic
    public void addSubscriber(String topic, PubSubService pubSubService) {
        pubSubService.addSubscriber(topic, this);
    }

    // Unsubscribe subscriber with PubSubService from a topic
    public void unSubscribe(String topic, PubSubService pubSubService) {
        pubSubService.removeSubscriber(topic, this);
    }

    // Request messages related to topic from PubSubService
    public void getMessagesForSubscriberOfTopic(String topic, PubSubService pubSubService) {
        pubSubService.getMessagesForSubscriberOfTopic(topic, this);
    }
}
