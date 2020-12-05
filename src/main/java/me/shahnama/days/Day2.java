package me.shahnama.days;

import me.shahnama.tools.Tools;

import java.util.List;

public class Day2 {

    private static final String PUZZLE_INPUT = "day2.txt" ;
    private List<String> puzzleInput;

    public Day2(){
        readInput();
    }

    private void readInput(){
        puzzleInput = new Tools().readInput(PUZZLE_INPUT);
    }

    public int solve_P1(){
        readInput();
        int validCounter = 0;
        for(String rawPattern : puzzleInput){
            String[] pattern = rawPattern.split(" ");
            String[] min_max =pattern[0].split("-");
            char Character=pattern[1].replace(":", "").toCharArray()[0];
            String password= pattern[2];

            int min = Integer.parseInt(min_max[0]);
            int max= Integer.parseInt(min_max[1]);
            char[] chars = password.toCharArray();

            int counter=0;
            for(char c : chars)
            {
                if(c==Character){
                    counter++;
                }
            }
            if(counter>=min && counter<=max){
                validCounter++;
            }
        }
        return validCounter;
    }

    public int solve_P2(){
        int validCounter = 0;
        for(String rawPattern : puzzleInput){
            String[] pattern = rawPattern.split(" ");
            String[] first_second =pattern[0].split("-");
            char Character=pattern[1].replace(":", "").toCharArray()[0];
            String password= pattern[2];
            int first = Integer.parseInt(first_second[0]);
            int second= Integer.parseInt(first_second[1]);
            char c1= password.charAt(first-1);
            char c2= password.charAt(second-1);

            if((c1 == Character) ^ (c2 ==Character)){
                validCounter++;
            }
        }
        return validCounter;
    }
}

