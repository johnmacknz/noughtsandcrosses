package noughtsandcrosses;

public enum Player {
    NOUGHTS("O"), CROSSES("X"), NO_PLAYER(" ");
    public final String symbol;
    Player(String symbol) {
        this.symbol = symbol;
    }
}
