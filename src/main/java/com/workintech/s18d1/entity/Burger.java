package com.workintech.s18d1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="burger", schema="s18d4")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="price")
    private Integer price;

    @Column(name = "isVegan")
    private boolean isVegan;

    @Enumerated(EnumType.STRING)
    private BreadType breadType;

    @Column(name="contents")
    private String contents;


}
