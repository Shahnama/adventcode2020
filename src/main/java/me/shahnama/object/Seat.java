package me.shahnama.object;

public class Seat {
    public int row;
    public int column;
    public String seatID;

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
