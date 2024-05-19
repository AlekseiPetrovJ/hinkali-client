package ru.petrov.hinkaliclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.petrov.hinkaliclient.model.Order;
import ru.petrov.hinkaliclient.services.OrderMessagingService;

@RestController
@RequestMapping("/client")
public class Client {

    private final OrderMessagingService messagingService;

    @Autowired
    public Client(OrderMessagingService messagingService) {
        this.messagingService = messagingService;
    }

    @GetMapping("/order")
    public Order getOrder() {
        return messagingService.receiveOrder();
    }
}