package com.platzi.pizza.persistence.audit;

import com.platzi.pizza.persistence.entity.PizzaEntity;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;
import org.springframework.util.SerializationUtils;

public class AuditPizzaListener {

    private PizzaEntity currentEntity;

    @PostLoad
    public void postLoad(PizzaEntity entity){
        System.out.println("POST LOAD");
        this.currentEntity = SerializationUtils.clone(entity);
    }

    @PostPersist
    @PostUpdate

    public void onPostPersist(PizzaEntity entity){
        System.out.println("POST PERSIST UPDATE");
        System.out.println("OLD VALUE: "+ this.currentEntity);
        System.out.println("NEW VALUE: "+ entity.toString());
    }

    @PreRemove

    public void onPreDelete(PizzaEntity entity){
        System.out.println(entity.toString());
    }
}
