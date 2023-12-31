package com.platzi.pizza.web.controller;

import com.platzi.pizza.persistence.entity.OrderEntity;
import com.platzi.pizza.persistence.proyection.OrderSummary;
import com.platzi.pizza.service.OrderService;
import com.platzi.pizza.service.dto.RandomOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAll(){
        return ResponseEntity.ok(this.orderService.getAll());
    }

    @GetMapping("/today")
    public ResponseEntity<List<OrderEntity>> getToday(){
        return ResponseEntity.ok(this.orderService.getTodayOrders());
    }

    @GetMapping("/outside")
    public ResponseEntity<List<OrderEntity>> getOutsideOrders(){
        return ResponseEntity.ok(this.orderService.getOutsideOrders());
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<OrderEntity>> getCustomerOrders( @PathVariable("id") String customerId){
        return ResponseEntity.ok(this.orderService.getCustomerOrders(customerId));
    }

    @GetMapping("/summary/{id}")
    public ResponseEntity<OrderSummary> getCustomerOrders(@PathVariable("id") int orderId){
        return ResponseEntity.ok(this.orderService.getSummary(orderId));
    }

    @PostMapping("/random")
    public ResponseEntity<Integer> randomOrder(@RequestBody RandomOrderDto dto){
        return ResponseEntity.ok(this.orderService.saveRandomOrder(dto));
    }
}
