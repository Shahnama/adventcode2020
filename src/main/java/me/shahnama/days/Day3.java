package me.shahnama.days;


import me.shahnama.tools.Tools;

import java.util.ArrayList;
import java.util.List;

public class Day3 {

    public Day3(){
        readInput();
    }

    private static final String PUZZLE_INPUT = "day3.txt" ;
    private List<String> puzzleInput;

    private void readInput(){
        puzzleInput = new Tools().readInput(PUZZLE_INPUT);
    }

    public long solve_P1(){
        readInput();
        int repeatLine = (puzzleInput.size()*7 +1)/(puzzleInput.get(0).toCharArray().length)+1;
        repeatInputLine(repeatLine);

        int[] downs = new int[]{1};
        int[] rights = new int[] { 3};

        List<Integer> counts = new ArrayList<>();

        for(int x=0;x<downs.length;x++){
            int col =0 ;
            int row = puzzleInput.size();
            int count = 0;
            for(int i=0 ; i<row;i=i+downs[x]){
                char point = puzzleInput.get(i).charAt(col);
                if(point=='#'){
                    count++;
                }
                col+=rights[x];
            }
            counts.add(count);
        }
        long result=1;
        for(int count:counts){
            result = result*count;
        }
        return result;
    }

    public long solve_P2(){
        readInput();
        int repeatLine = (puzzleInput.size()*7 +1)/(puzzleInput.get(0).toCharArray().length)+1;
        repeatInputLine(repeatLine);

        int[] downs = new int[]{1,1,1,1,2};
        int[] rights = new int[] { 1,3,5,7,1};

        List<Integer> counts = new ArrayList<>();

        for(int x=0;x<downs.length;x++){
            int col =0 ;
            int row = puzzleInput.size();
            int count = 0;
            for(int i=0 ; i<row;i=i+downs[x]){
                char point = puzzleInput.get(i).charAt(col);
                if(point=='#'){
                    count++;
                }
                col+=rights[x];
            }
            counts.add(count);
        }
        long result=1;
        for(int count:counts){
            result = result*count;
        }
        return result;
    }

    private void repeatInputLine(int repeatLine){
        List<String> expandPuzzleInput = new ArrayList<>();

        for(String inputLine: puzzleInput){
            expandPuzzleInput.add(String.valueOf(inputLine).repeat(Math.max(0, repeatLine)));
        }
        puzzleInput =expandPuzzleInput;
    }
}

