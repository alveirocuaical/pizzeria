package com.platzi.pizza.service.dto;

import lombok.Data;

@Data // crea todos los getter/setters and contructor methods
public class UpdatePizzaPriceDto {

    private int pizzaId;

    private double newPrice;
}
