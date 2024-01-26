package dev.habibzad.brewscape.controller;

import dev.habibzad.brewscape.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {
    private final List<Order> orders;

    public OrderController() {
        orders = new LinkedList<>();
    }

    @GetMapping()
    public List<Order> listOrders() {
        return orders;
    }

    @PostMapping()
    public ResponseEntity<String> placeOrder(@RequestBody Order order) {
        orders.add(order);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    @PatchMapping("/process/{id}")
    public ResponseEntity<String> processOrder(@PathVariable int id) {
        Order order = orders.stream().filter(o -> o.getOrderId() == id).findFirst().orElseThrow();
        order.setStatus("Processing");
        return new ResponseEntity<>("Processing", HttpStatus.ACCEPTED);
    }

    @PatchMapping("/complete/{id}")
    public ResponseEntity<String> completeOrder(@PathVariable int id) {
        Order order = orders.stream().filter(o -> o.getOrderId() == id).findFirst().orElseThrow();
        order.setStatus("Completed");
        return new ResponseEntity<>("Completed", HttpStatus.ACCEPTED);
    }


}
