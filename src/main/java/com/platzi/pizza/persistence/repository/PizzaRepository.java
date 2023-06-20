package com.platzi.pizza.persistence.repository;

import com.platzi.pizza.persistence.entity.PizzaEntity;
import com.platzi.pizza.service.dto.UpdatePizzaPriceDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {

    List<PizzaEntity> findAllByAvailableOrderByPrice(int available);

    Optional<PizzaEntity> findFirstByAvailableAndAndNameIgnoreCase(int available, String name);

    List<PizzaEntity> findAllByDescriptionContainingIgnoreCase(String description);

    List<PizzaEntity> findAllByDescriptionNotContainingIgnoreCase(String description);

    int countByVegan(int vegan);

    List<PizzaEntity> findTop3ByAvailableAndPriceLessThanEqualOrderByPriceAsc(int available, double price);

    @Query(value =
            "UPDATE pizza " +
            "   SET price = :#{#newPizzaPrice.newPrice}" +
            "   WHERE id_pizza = :#{#newPizzaPrice.pizzaId}", nativeQuery = true)
    @Modifying
    void updatePrice(@Param("newPizzaPrice")UpdatePizzaPriceDto newPizzaPrice);
}
