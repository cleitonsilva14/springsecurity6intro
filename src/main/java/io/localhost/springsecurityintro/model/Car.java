package io.localhost.springsecurityintro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Column(name = "name", length = 250)
    private String name;

    @Column(name = "make", length = 120)
    private String make;

    @Column(name = "year")
    private int year;

    @Column(name = "price", scale = 8, precision = 10)
    private BigDecimal price = new BigDecimal("0.0");

}
