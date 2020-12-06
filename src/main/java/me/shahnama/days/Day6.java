package me.shahnama.days;

import me.shahnama.tools.Tools;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Day6 {
    private final String PUZZLE_INPUT;
    private List<String> puzzleInput;

    private static final int ERROR_NUMBER= Integer.MIN_VALUE;
    private static final String SPLIT_STRING= "";

    public Day6(String PUZZLE_INPUT){
        this.PUZZLE_INPUT = PUZZLE_INPUT;
        readInput();
    }

    private void readInput(){
        puzzleInput = new Tools().readInput(PUZZLE_INPUT);
    }

    public int solve_P1() {
        List<String> groupAnswer = getEachGroupAnswer();
        int sum = 0;
        for(String data:groupAnswer) {
            Set<Character> uniqueAnswer = uniqueCharCount(null, data);
            sum +=uniqueAnswer.size();
        }
        return sum;
    }

    public int solve_P2() {
        Set<Character> uniqueAnswer = null;
        int count =0;
        for(String data:puzzleInput){
            if(data.equals(SPLIT_STRING)){
                count+= uniqueAnswer != null ? uniqueAnswer.size() : ERROR_NUMBER;
                uniqueAnswer = null;
                continue;
            }
            uniqueAnswer = uniqueCharCount(uniqueAnswer, data);
        }
        count+= uniqueAnswer != null ? uniqueAnswer.size() :ERROR_NUMBER;
        return count;
    }

    private List<String>  getEachGroupAnswer(){
        StringBuilder oneGroupAnswer= new StringBuilder();
        List<String> groupAnswer = new ArrayList<>();
        for(String data:puzzleInput){
            if(data.equals(SPLIT_STRING)){
                groupAnswer.add(oneGroupAnswer.toString());
                oneGroupAnswer = new StringBuilder();
            }
            oneGroupAnswer.append(data);
        }
        groupAnswer.add(oneGroupAnswer.toString());
        return groupAnswer;
    }

    private Set<Character> uniqueCharCount(Set<Character> inputSet , String input) {
        Set<Character> uniqueAnswer = new LinkedHashSet<>();
        for (char c : input.toCharArray()) {
            if (inputSet == null || inputSet.contains(c)) {
                uniqueAnswer.add(c);
            }
        }
        return uniqueAnswer;
    }
}
