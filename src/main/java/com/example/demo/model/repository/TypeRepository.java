package com.example.demo.model.repository;

import com.example.demo.model.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

    @Query("select t from Type t where t.disabled = 'N'")
    List<Type> showAll();
}
