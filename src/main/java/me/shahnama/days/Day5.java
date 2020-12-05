package me.shahnama.days;

import me.shahnama.object.Seat;
import me.shahnama.tools.AnswerNotFindException;
import me.shahnama.tools.Tools;

import java.util.ArrayList;
import java.util.List;

public class Day5 {
    private final String PUZZLE_INPUT;
    private List<String> puzzleInput;
    private final List<Seat> seatList = new ArrayList<>();

    public Day5(String PUZZLE_INPUT){
        this.PUZZLE_INPUT = PUZZLE_INPUT;
        readInput();
    }




    private void readInput(){
        puzzleInput = new Tools().readInput(PUZZLE_INPUT);
    }

    public int solve_P1() {
        int maxSeatID= Integer.MIN_VALUE;

        for(String data: puzzleInput){
            int rowMax = 127;
            int rowMin = 0;
            int row = -1;
            int columnMax = 7;
            int columnMin = 0;
            int column = -1;
            int seatID;
            for(int i=0;i<7;i++){
                if(data.charAt(i)=='B') {
                    rowMin = rowMin + (rowMax-rowMin+1)/2;
                }else if(data.charAt(i)=='F'){
                    rowMax = rowMax - (rowMax-rowMin+1)/2;
                }else{
                    System.out.print("ERROR");
                }
            }
            if(rowMax==rowMin){
                row= rowMax;
            }else{
                System.out.print("ERROR, Row MAZ != ROW MIN ");
            }
            for(int i=7;i<10;i++){
                if(data.charAt(i)=='R'){
                    columnMin = columnMin + (columnMax-columnMin+1)/2;
                }else if(data.charAt(i)=='L'){
                    columnMax = columnMax - (columnMax-columnMin+1)/2;
                }else{
                    System.out.print("ERROR");
                }
            }
            if(columnMax==columnMin){
                column= columnMax;
            }else{
                System.out.print("ERROR, Row MAZ != ROW MIN ");
            }
            seatID = row * 8 + column;
            seatList.add(new Seat(row,column,String.valueOf(seatID)));
            if(maxSeatID<seatID) {
                maxSeatID = seatID;
            }
        }
        return maxSeatID;
    }

    public int solve_P2() throws AnswerNotFindException {
        this.solve_P1();
        int rowMax = 127;
        int columnMax = 7;

        List<String> allSeatIds = new ArrayList<>();
        for (int row =0 ; row<rowMax;row++){
            for (int column =0 ; column<columnMax;column++){
                allSeatIds.add(String.valueOf(row * 8 + column));
            }
        }
        for(Seat seat: seatList){
            allSeatIds.remove(seat.seatID);
        }

        for(String emptySeat: allSeatIds){
            int mySeat = Integer.parseInt(emptySeat);
            if(!allSeatIds.contains(String.valueOf(mySeat+1)) && !allSeatIds.contains(String.valueOf(mySeat-1))){
                return mySeat;
            }
        }
        throw new AnswerNotFindException("Unexpected orientation");
    }
}
