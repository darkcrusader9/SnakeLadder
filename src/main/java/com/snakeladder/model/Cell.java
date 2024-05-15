package com.snakeladder.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Cell {
    int number;
    Move move;

    public Cell(int number) {
        this.number = number;
    }
}
