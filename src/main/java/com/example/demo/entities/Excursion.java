package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.HashSet;
import java.util.Set;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table (name="excursions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="excursion_id")
    private Long id;

    @Column(name ="excursion_title")
    private String excursion_title;

    @Column(name ="excursion_price")
    private BigDecimal excursion_price;

    @Column(name ="image_URL")
    private String image_URL;

    @CreationTimestamp
    @Column(name ="create_date")
    private java.util.Date create_date;

    @UpdateTimestamp
    @Column(name ="last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name ="vacation_id")
    private Vacation vacation;

    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems  = new HashSet<>();


}

