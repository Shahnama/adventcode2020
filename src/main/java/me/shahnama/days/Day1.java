package me.shahnama.days;

import me.shahnama.tools.AnswerNotFindException;
import me.shahnama.tools.Tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1 {

    private final String PUZZLE_INPUT;

    private static final int SUM = 0;
    private static final int MULTIPLICATION = 1;
    private static final int TARGET_YEAR = 2020;
    private List<Integer> puzzleInput;

    public Day1(String PUZZLE_INPUT ){
        this. PUZZLE_INPUT = PUZZLE_INPUT ;
        readInput();
    }

    private void readInput(){
        puzzleInput = new ArrayList<>();
        for(String input :new Tools().readInput(PUZZLE_INPUT)){
            puzzleInput.add(Integer.parseInt(input));
        }
        Collections.sort(puzzleInput);
    }
    public int solve_P1() throws AnswerNotFindException {
        for(int i = 0; i< puzzleInput.size(); i++ ){
            for(int j = puzzleInput.size()-1; j>i; j-- ){
                if(numberHandler(SUM,i,j)==TARGET_YEAR){
                    return numberHandler(MULTIPLICATION,i,j);
                }
                if(numberHandler(SUM,i,j)<TARGET_YEAR)
                    break;
            }
        }
        throw new AnswerNotFindException("Unexpected orientation");
    }

    public int solve_P2() throws AnswerNotFindException {
        for(int i=0;i<puzzleInput.size();i++ ){
            for(int j=i+1;j<puzzleInput.size();j++ ){
                for(int k=j+1;k<puzzleInput.size();k++ ){
                    if(numberHandler(SUM,i,j,k)==TARGET_YEAR){
                        return numberHandler(MULTIPLICATION,i,j,k);
                    }else if(numberHandler(SUM,i,j,k)>TARGET_YEAR){
                        break;
                    }
                }
            }
        }
        throw new AnswerNotFindException("Unexpected orientation");
    }

    private int numberHandler(int operation , int ... inputIndexList){
        int result = operation;
        for(int index : inputIndexList){
            if(operation==SUM) {
                result += puzzleInput.get(index);
            }else if(operation==MULTIPLICATION){
                result *= puzzleInput.get(index);
            }
        }
        return result;
    }
}

