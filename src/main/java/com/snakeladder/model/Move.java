package com.snakeladder.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Move {
    int start;
    int destination;
    public Move(int start, int destination){
        this.start = start;
        this.destination = destination;
    }
}
