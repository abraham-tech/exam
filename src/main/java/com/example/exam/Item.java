package com.example.exam;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name="items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer price;
    private String color;

    public Item() {}

    public Item(String name, Integer price, String color) {
        this.name = name;
        this.price = price;
        this.color = color;
    }
}
