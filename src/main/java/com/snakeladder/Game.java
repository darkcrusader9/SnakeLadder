package com.snakeladder;

import com.snakeladder.model.Board;
import com.snakeladder.model.Cell;
import com.snakeladder.model.Dice;
import com.snakeladder.model.Player;

import java.util.ArrayDeque;
import java.util.Deque;

public class Game {
    public static void main(String[] args) {
        int size = 10;
        Board board = new Board(size, 10, 10);
        System.out.println("-----Displaying Board--------");
        board.printBoard();
        System.out.println("----------------------");
        Dice dice = new Dice(1);

        //Players
        Player p1 = new Player("1", 1);
        Player p2 = new Player("2", 1);
        Player p3 = new Player("3", 1);
        Deque<Player> playerList  = new ArrayDeque<>();
        playerList.add(p1);
        playerList.add(p2);
        playerList.add(p3);
        Player winner = null;

        while(winner == null){
            Player inTurn = playerList.removeFirst();
            playerList.addLast(inTurn);

            int numMoves = dice.getFace();
            int newPosition = inTurn.getCurrentPosition() + numMoves;

            if(newPosition <= (size * size)){
                Cell cell = board.getCell(newPosition);

                if(cell.getMove() != null){
                    newPosition = cell.getMove().getDestination();
                }

                if(newPosition <= (size * size))
                    inTurn.setCurrentPosition(newPosition);

                if(inTurn.getCurrentPosition() == (size * size)){
                    winner = inTurn;
                }
            }
            System.out.println("player turn is:" + inTurn.getId() + " new Position is: " + inTurn.getCurrentPosition());
            if(winner != null)
                break;
        }

        System.out.println("Winner is " + winner.getId());
    }
}
