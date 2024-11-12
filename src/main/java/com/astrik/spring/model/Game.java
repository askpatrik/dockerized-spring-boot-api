package com.astrik.spring.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "game_inventory")
@Data

public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "game_name")
    private String gameName;

    @Column(name = "price")
    private int price;

    // Getter for id
    public long getId() {
        return id;
    }

    // Setter for id
    public void setId(long id) {
        this.id = id;
    }

    // Getter for gameName
    public String getGameName() {
        return gameName;
    }

    // Setter for gameName
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    // Getter for price
    public int getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(int price) {
        this.price = price;
    }
}
