package com.snakeladder.model;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Player {
    String id;
    int currentPosition;

    public Player(String id, int currentPosition) {
        this.id = id;
        this.currentPosition = currentPosition;
    }

    //getters and setters
}

