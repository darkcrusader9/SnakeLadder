package com.snakeladder.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Dice {
    int numDices;
    int face;

    public Dice(int numDices){
        this.numDices = numDices;
    }
    public int getFace(){
        int sum = 0;
        for(int i = 0; i < numDices; i++){
            Random random = new Random();
            sum += random.nextInt(6) + 1;
        }
        return sum;
    }
}
