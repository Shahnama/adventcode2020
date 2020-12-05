package me.shahnama.object;

public class Seat {
    public final int row;
    public final int column;
    public final String seatID;

    public Seat(    int row, int column, String seatID ) {
        this. row = row ;
        this. column = column;
        this. seatID =seatID;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "row=" + row +
                ", column=" + column +
                ", seatID=" + seatID +
                '}';
    }
}
