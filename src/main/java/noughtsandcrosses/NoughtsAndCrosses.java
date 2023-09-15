package noughtsandcrosses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class NoughtsAndCrosses {
    Scanner systemScanner = new Scanner(System.in);
    Board board = new Board();
    ArrayList<Move> pastMoves = new ArrayList<>();
    HashMap<String, Boolean> moveAvailabilityMap = new HashMap<>();
    public void playGame() {
        boolean winConditionMet;
        Player currentPlayer = Player.CROSSES;
        updateMoveAvailability();
        board.clearBoard();
        do {
            System.out.println("Current board:");
            board.printBoard();
            System.out.println(currentPlayer + "'s turn!");
            Move move = makeMove(currentPlayer);
            pastMoves.add(move);
            updateMoveAvailability();
            currentPlayer = switchPlayer(currentPlayer);
            winConditionMet = board.checkIfWin();
        } while (!winConditionMet && pastMoves.size() != 9);
        if (winConditionMet) {
            currentPlayer = switchPlayer(currentPlayer);
            System.out.println("Final board:");
            board.printBoard();
            System.out.println(currentPlayer + " wins!");
        }
        else {
            System.out.println("Final board:");
            board.printBoard();
            System.out.println("Draw!");
        }
    }
    private Move makeMove(Player player) {
        boolean validMove;
        Move move = null;
        do {
            System.out.println("Please enter one of the following available moves:");
            for (String moveString : moveAvailabilityMap.keySet()) {
                if (moveAvailabilityMap.get(moveString)) {
                    System.out.println(moveString);
                }
            }
            String moveInput = systemScanner.nextLine();
            try {
                move = parseMove(moveInput);
                validMove = true;
                if (pastMoves.contains(move)) {
                    System.out.println("That box is already full. Try again!");
                    validMove = false;
                }
            } catch (Exception e) {
                System.out.println("Invalid move. Try again!");
                validMove = false;
            }
        } while (!validMove);
        board.drawSymbol(player, move);
        return move;
    }
    private Move parseMove(String moveString) {
        String[] moveIndices = moveString.split(" ");
        String firstIndex = moveIndices[0].toUpperCase();
        String secondIndex = moveIndices[moveIndices.length-1].toUpperCase();
        return Move.valueOf( firstIndex + "_" + secondIndex);
    }
    private void updateMoveAvailability() {
        moveAvailabilityMap.clear();
        for (Move move: Move.values()) {
            if (pastMoves.contains(move)) {
                moveAvailabilityMap.put(move.moveString, false);
            }
            else {
                moveAvailabilityMap.put(move.moveString, true);
            }
        }
    }
    private Player switchPlayer(Player lastPlayer) {
        Player nextPlayer = null;
        switch (lastPlayer) {
            case CROSSES -> nextPlayer = Player.NOUGHTS;
            case NOUGHTS -> nextPlayer = Player.CROSSES;
            case NO_PLAYER -> nextPlayer = Player.NO_PLAYER;
        }
        return nextPlayer;
    }
}
