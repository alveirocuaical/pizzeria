package com.platzi.pizza.persistence.proyection;

import java.time.LocalDateTime;

public interface OrderSummary {

    Integer getIdOrder();

    String getCustomerName();

    LocalDateTime getOrderDate();

    Double getOrderTotal();

    String getPizzaNames();
}
