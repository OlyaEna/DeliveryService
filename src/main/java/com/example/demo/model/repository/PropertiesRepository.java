package com.example.demo.model.repository;

import com.example.demo.model.entity.Properties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertiesRepository extends JpaRepository<Properties, String> {

    @Query("select c.value from Properties c where c.id = 'm'")
    double deliveryPrice();

    @Query("select c.value from Properties c where c.id = 'x'")
    double sumForFreeDelivery();

    @Query("select c.value from Properties c where c.id = 'n'")
    int freeCoffeeCup();
}
