package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name="countries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long country_id;

    @Column(name = "country")
    private String country;

    @CreationTimestamp
    @Column(name = "create_date")
    private java.sql.Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "country")
    private Set<Division> divisions = new HashSet<>();

    public Long getId() {
        return country_id;
    }
}


