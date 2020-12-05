package me.shahnama.days;

import me.shahnama.object.Seat;
import me.shahnama.tools.AnswerNotFindException;
import me.shahnama.tools.Tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day5 {

    public Day5(){
        readInput();
    }

    private static final String PUZZLE_INPUT = "day5.txt" ;
    private List<String> puzzleInput;
    private List<Seat> seatList = new ArrayList<>();


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
            //System.out.print(data + " ");
            for(int i=0;i<7;i++){
                if(data.charAt(i)=='B') {
                    rowMax = rowMax;
                    rowMin = rowMin + (rowMax-rowMin+1)/2;
                }else if(data.charAt(i)=='F'){
                    rowMax = rowMax - (rowMax-rowMin+1)/2;
                    rowMin = rowMin;
                }else{
                    System.out.print("ERROR");
                }
//                System.out.print(data.charAt(i) + "");
//                System.out.print("(" + (rowMin) + " " + (rowMax) + ") ");

            }
            if(rowMax==rowMin){
                row= rowMax;
            }else{
                System.out.print("ERROR, Row MAZ != ROW MIN ");
            }
            //System.out.print(" Row " + row);
            //System.out.print("\t");
            for(int i=7;i<10;i++){
                if(data.charAt(i)=='R'){
                    columnMin = columnMin + (columnMax-columnMin+1)/2;
                }else if(data.charAt(i)=='L'){
                    columnMax = columnMax - (columnMax-columnMin+1)/2;
                }else{
                    System.out.print("ERROR");
                }
//                System.out.print(data.charAt(i) + " ");
            }
            if(columnMax==columnMin){
                column= columnMax;
            }else{
                System.out.print("ERROR, Row MAZ != ROW MIN ");
            }
            //System.out.print(" column " + column);
            seatID = row * 8 + column;
            //System.out.print(" column " + column);
            //System.out.print(" seatID " + seatID);
            seatList.add(new Seat(row,column,String.valueOf(seatID)));
            if(maxSeatID<seatID) {
                maxSeatID = seatID;
            }
            //System.out.println("");
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
//            System.out.println(seat.toString());
        }

        for(String emptySeat: allSeatIds){
//            allSeatIds.remove(seat.seatID);
            int mySeat = Integer.parseInt(emptySeat);

            if(!allSeatIds.contains(String.valueOf(mySeat+1)) && !allSeatIds.contains(String.valueOf(mySeat-1))){
                return mySeat;
            }

        }
        throw new AnswerNotFindException("Unexpected orientation");
    }
}
