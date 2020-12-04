package me.shahnama.days;

import me.shahnama.tools.Tools;

import java.util.ArrayList;
import java.util.List;

public class Day5 {

    public Day5(){
        readInput();
    }

    private static final String PUZZLE_INPUT = "test5.txt" ;
    private List<String> puzzleInput;


    private void readInput(){
        puzzleInput = new Tools().readInput(PUZZLE_INPUT);
    }

    public int solve_P1() {
        for(String data: puzzleInput){
//            System.out.println(data);
        }
        return puzzleInput.size();
    }

    public int solve_P2() {
        for(String data: puzzleInput){
            System.out.println(data);
        }
        return puzzleInput.size();
    }
}
