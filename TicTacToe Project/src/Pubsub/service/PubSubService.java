package Pubsub.service;

import Pubsub.message.Message;
import Pubsub.subscriber.Subscriber;

import java.util.*;

public class PubSubService {
    // Keeps set of subscriber topic wise to prevent duplicates
    Map<String, Set<Subscriber>> subscribersTopicMap = new HashMap<String, Set<Subscriber>>();

    // Holds messages published by publisher
    Queue<Message> messageQueue = new LinkedList<Message>();

    // Adds messages sent by publisher to queue
    public void addMessageToQueue(Message message) {
        messageQueue.add(message);
    }

    // Add a new subscriber for a topic
    public void addSubscriber(String topic, Subscriber subscriber) {
        if(subscribersTopicMap.containsKey(topic)) {
            Set<Subscriber> subscribers = subscribersTopicMap.get(topic);
            subscribers.add(subscriber);
            subscribersTopicMap.put(topic, subscribers);
        } else {
            Set<Subscriber> subscribers = new HashSet<Subscriber>();
            subscribers.add(subscriber);
            subscribersTopicMap.put(topic, subscribers);
        }
    }

    // Remove an existing subscriber from a topic
    public void removeSubscriber(String topic, Subscriber subscriber) {
        if(subscribersTopicMap.containsKey(topic)) {
            Set<Subscriber> subscribers = subscribersTopicMap.get(topic);
            subscribers.remove(subscriber);
            subscribersTopicMap.put(topic, subscribers);
        }
    }

    // Broadcast new messages added in queue to all subscribers of topic. messageQueue
    // will be empty after broadcasting.
    public void broadcast() {
        if(messageQueue.isEmpty()) {
            System.out.println("No messages to display");
        } else {
            while (!messageQueue.isEmpty()) {
                Message message = messageQueue.remove();
                String topic = message.getTopic();

                Set<Subscriber> subscriberOfTopic = subscribersTopicMap.get(topic);

                for(Subscriber subscriber : subscriberOfTopic) {
                    // add broadcasted message to subscribers message queue
                    List<Message> subscriberMessages = subscriber.getSubscriberMessages();
                    subscriberMessages.add(message);
                    subscriber.setSubscriberMessages(subscriberMessages);

                    // send messages to corresponding sockets
                }
            }
        }
    }

    // Sends messages about a topic for subscriber at any point
    public void getMessagesForSubscriberOfTopic(String topic, Subscriber subscriber) {
        if(messageQueue.isEmpty()) {
            System.out.println("No messages from publishers to display.");
        } else {
            while (!messageQueue.isEmpty()) {
                Message message = messageQueue.remove();

                if(message.getTopic().equalsIgnoreCase(topic)) {

                    Set<Subscriber> subscribersOfTopic = subscribersTopicMap.get(topic);

                    for(Subscriber _subscriber : subscribersOfTopic) {
                        // add broadcasted message to subscriber message queue
                        List<Message> subscriberMessages = subscriber.getSubscriberMessages();
                        subscriberMessages.add(message);
                        subscriber.setSubscriberMessages(subscriberMessages);

                        // corresponding sockets
                    }
                }
            }
        }
    }
}
