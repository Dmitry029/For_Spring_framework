package com.udemy.spring.springselenium.repository;

import com.udemy.spring.springselenium.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Customer, Integer> {
}
