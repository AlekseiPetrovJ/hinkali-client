package ru.petrov.hinkaliclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.petrov.hinkaliclient.model.Ingredient;
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

    @GetMapping
    public Ingredient getIngredient() {
        RestTemplate rest = new RestTemplate();
        Ingredient ingredient = new Ingredient("INGR", "Hello Ingredient", Ingredient.Type.PROTEIN);
        ResponseEntity<Ingredient> responseEntity = rest.postForEntity("http://127.0.0.1:8080/data-api/ingredients", ingredient, Ingredient.class);
        System.out.println(responseEntity.getStatusCode());

        return rest.getForObject("http://127.0.0.1:8080/data-api/ingredients/KTCH",
                Ingredient.class);
    }

    @GetMapping("/order")
    public Order getOrder() {
        return messagingService.receiveOrder();
    }

}
