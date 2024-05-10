package com.yash.grapghqldemo.repositories;

import com.yash.grapghqldemo.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepo extends JpaRepository<Order ,Integer> {

    //  custom query methods
    //  custom finder methods

}
