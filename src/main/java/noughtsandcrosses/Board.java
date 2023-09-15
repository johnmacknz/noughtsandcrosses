package noughtsandcrosses;

public class Board {
    private final int BOARD_SIZE = 3;
    public String[][] currentBoard = new String[BOARD_SIZE][BOARD_SIZE];

    public void drawSymbol(Player player, Move move) {
        switch (move) {
            case TOP_LEFT -> currentBoard[0][0] = player.symbol;
            case TOP_MIDDLE -> currentBoard[0][1] = player.symbol;
            case TOP_RIGHT -> currentBoard[0][2] = player.symbol;
            case MIDDLE_LEFT -> currentBoard[1][0] = player.symbol;
            case MIDDLE_MIDDLE -> currentBoard[1][1] = player.symbol;
            case MIDDLE_RIGHT -> currentBoard[1][2] = player.symbol;
            case BOTTOM_LEFT -> currentBoard[2][0] = player.symbol;
            case BOTTOM_MIDDLE -> currentBoard[2][1] = player.symbol;
            case BOTTOM_RIGHT -> currentBoard[2][2] = player.symbol;
        }
    }
    public boolean checkIfWin() {
        boolean winConditionMet = false;
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (currentBoard[i][0].equals(currentBoard[i][1]) &&
                    currentBoard[i][1].equals(currentBoard[i][2]) &&
                    !currentBoard[i][2].equals(Player.NO_PLAYER.symbol)) {
                winConditionMet = true;
                break;
            }
            else if (currentBoard[0][i].equals(currentBoard[1][i]) &&
                    currentBoard[1][i].equals(currentBoard[2][i]) &&
                    !currentBoard[2][i].equals(Player.NO_PLAYER.symbol)) {
                winConditionMet = true;
                break;
            }
            else if (currentBoard[0][0].equals(currentBoard[1][1]) &&
                    currentBoard[1][1].equals(currentBoard[2][2]) &&
                    !currentBoard[2][2].equals(Player.NO_PLAYER.symbol)) {
                winConditionMet = true;
                break;
            }
            else if (currentBoard[0][2].equals(currentBoard[1][1]) &&
                    currentBoard[1][1].equals(currentBoard[2][0]) &&
                    !currentBoard[2][0].equals(Player.NO_PLAYER.symbol)) {
                winConditionMet = true;
                break;
            }
        }
        return winConditionMet;
    }
    public void clearBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                currentBoard[i][j] = Player.NO_PLAYER.symbol;
            }
        }
    }
    public void printBoard() {
        System.out.printf("""
                 %s | %s | %s 
                ---+---+---
                 %s | %s | %s 
                ---+---+---
                 %s | %s | %s
                """,
                currentBoard[0][0], currentBoard[0][1], currentBoard[0][2],
                currentBoard[1][0], currentBoard[1][1], currentBoard[1][2],
                currentBoard[2][0], currentBoard[2][1], currentBoard[2][2]);
    }
}
