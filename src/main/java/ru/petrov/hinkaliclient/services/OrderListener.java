package ru.petrov.hinkaliclient.services;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ru.petrov.hinkaliclient.model.Order;

@Component
public class OrderListener {

    @JmsListener(destination = "hinkali.cloud.queue")
    public void receiveOrder(Order order) {
        System.out.println(order);
    }
}