package com.snakeladder.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Random;

@Setter
@Getter
public class Board {
    Cell[][] board;
    int size;
    int numSnakes;
    int numLadders;
    Random random;
    HashMap<Integer, Cell> numToCellMapping;
    public Board(int size, int numSnakes, int numLadders){
        this.size = size;
        board = new Cell[size][size];
        this.numSnakes = numSnakes;
        this.numLadders = numLadders;
        random = new Random();
        numToCellMapping = new HashMap<>();
        initializeBoard();
        addSnakes();
        addLadder();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int cellNumber = i * size + j + 1;
                Cell cell = new Cell(cellNumber);
                board[i][j] = cell;
                numToCellMapping.put(cellNumber, cell);
            }
        }
    }

    public void addSnakes() {
        //generate random number from 1 to 100
        int snakesAdded = 0;
        while (snakesAdded < numSnakes) {
            int numHead = random.nextInt(size * size) + 1;
            int numTail = random.nextInt(size * size) + 1;
            Cell head = numToCellMapping.get(numHead);

            if (numTail > numHead || numHead == size * size)
                continue;

            snakesAdded++;
            Move snakeObj = new Move(numHead, numTail);
            head.setMove(snakeObj);
        }
    }

    public void addLadder(){
        int ladderAdded = 0;
        while(ladderAdded < numLadders) {
            int numHead = random.nextInt(size * size) + 1;
            int numTail = random.nextInt(size * size) + 1;
            Cell head = numToCellMapping.get(numHead);

            if (numTail < numHead || numHead == (size * size))
                continue;

            ladderAdded++;
            Move ladderObj = new Move(numHead, numTail);
            head.setMove(ladderObj);
        }
    }

    public Cell getCell(int number){
        if(number < 0 || number > (size * size)){
            System.out.println("Invalid");
        }
        return numToCellMapping.get(number);
    }

    public void printBoard(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.println(board[i][j]);
            }
        }
    }
}
