package ru.petrov.hinkaliclient.services;

import ru.petrov.hinkaliclient.model.Order;

public interface OrderMessagingService {
    void sendOrder(Order order);

    Order receiveOrder();
}