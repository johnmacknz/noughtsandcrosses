package noughtsandcrosses;

public enum Move {
    TOP_LEFT("top left"), TOP_MIDDLE("top middle"), TOP_RIGHT("top right"),
    MIDDLE_LEFT("middle left"), MIDDLE_MIDDLE("middle"), MIDDLE_RIGHT("middle right"),
    BOTTOM_LEFT("bottom left"), BOTTOM_MIDDLE("bottom middle"), BOTTOM_RIGHT("bottom right");
    public final String moveString;
    Move(String moveString) {
        this.moveString = moveString;
    }
}
