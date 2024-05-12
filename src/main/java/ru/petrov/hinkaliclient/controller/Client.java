package ru.petrov.hinkaliclient.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.petrov.hinkaliclient.model.Ingredient;

@RestController
@RequestMapping("/client")
public class Client {

    @GetMapping
    public Ingredient getIngredient(){
        RestTemplate rest = new RestTemplate();
        Ingredient ingredient = new Ingredient("INGR", "Hello Ingredient", Ingredient.Type.PROTEIN);
        ResponseEntity<Ingredient> responseEntity = rest.postForEntity("http://127.0.0.1:8080/data-api/ingredients", ingredient, Ingredient.class);
        System.out.println(responseEntity.getStatusCode());

        return rest.getForObject("http://127.0.0.1:8080/data-api/ingredients/KTCH",
                Ingredient.class);
//        return new Ingredient("INGR", "hello Ingridient", Ingredient.Type.PROTEIN);
    }
}
