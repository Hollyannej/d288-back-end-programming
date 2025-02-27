package com.example.demo.dao;


import com.example.demo.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
