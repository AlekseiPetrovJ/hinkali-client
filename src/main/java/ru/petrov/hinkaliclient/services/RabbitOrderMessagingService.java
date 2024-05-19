package ru.petrov.hinkaliclient.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import ru.petrov.hinkaliclient.model.Order;

@Service
public class RabbitOrderMessagingService implements OrderMessagingService{
    private final RabbitTemplate rabbit;
    @Autowired
    public RabbitOrderMessagingService(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
    }
    @Override
    public void sendOrder(Order order) {
        rabbit.convertAndSend("hinkalicloud.order", order);
    }

    @Override
    public Order receiveOrder() {
        return rabbit.receiveAndConvert("hinkalicloud.order.queue",
                new ParameterizedTypeReference<Order>() {});
    }
}