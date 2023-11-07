package Pubsub.publisher;

import Pubsub.message.Message;
import Pubsub.service.PubSubService;

public interface Publisher {
    // Publishes new message to pubsub service
    void  publish(Message message, PubSubService pubSubService);
}
