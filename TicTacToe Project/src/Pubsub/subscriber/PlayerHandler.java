package Pubsub.subscriber;

import Pubsub.service.PubSubService;
import sample.Player;

import java.io.*;
import java.net.Socket;

public class PlayerHandler extends Subscriber implements Runnable{
    private ObjectInputStream inObj;
    private ObjectOutputStream outObj;

    public PlayerHandler(Socket socket, String name, DataInputStream in, DataOutputStream out) {
        super(socket, name, in, out);
    }

    public PlayerHandler(Socket socket, String name, DataInputStream in, DataOutputStream out, ObjectInputStream inObj, ObjectOutputStream outObj) {
        super(socket, name, in, out);
        this.inObj = inObj;
        this.outObj = outObj;
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

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("PlayerHand");
                Player user = (Player) inObj.readObject();
                System.out.println(user.getUsername());
                System.out.println("Got obj");
                System.out.println(user.getUsername());
                if(user.getUsername() == "Toby") {
                    // end loop if username toby is assigned;
                    break;
                }

            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
