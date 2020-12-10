package me.shahnama.days;

import me.shahnama.tools.Tools;

import java.util.*;

public class Day10 {
    private final String PUZZLE_INPUT;
    private List<Integer> puzzleInput;
    private HashMap<Integer,Integer> distinctWaysGrid;

    long count = 0;

    public Day10(String PUZZLE_INPUT) {
        this.PUZZLE_INPUT = PUZZLE_INPUT;
        readInput();
    }

    private void readInput() {
        List<String> puzzleInputString = new Tools().readInput(PUZZLE_INPUT);
        puzzleInput = new ArrayList<>();
        for (String data : puzzleInputString) {
            puzzleInput.add(Integer.parseInt(data));
        }
        puzzleInput.add(0);
        puzzleInput.add(Collections.max(puzzleInput)+3);

        Collections.sort(puzzleInput);
    }

    public int solve_P1() {
        int diff3 = 0;
        int diff1 = 0;
        int startIndex = 0;

        for (int i = startIndex + 1; i < puzzleInput.size(); i++) {
            int diff = puzzleInput.get(i)- puzzleInput.get(i-1);
            switch (diff) {
                case 3 -> diff3++;
                case 1 -> diff1++;
                default -> System.out.println("Error");
            }
        }
        return diff1 * diff3;
    }

    public long solve_P2() {
        distinctWaysGrid = new HashMap<>();
        return distinctWays(0);
    }

    private int distinctWays(int startIndex) {
        int answer = 0;
        if(startIndex==puzzleInput.size()-1){
            return 1;
        }
        if(distinctWaysGrid.containsKey(startIndex)){
            return distinctWaysGrid.get(startIndex);
        }
        for(int i=startIndex+1;i<puzzleInput.size() && i<i+3;i++){
            if(puzzleInput.get(i)-puzzleInput.get(startIndex) <=3){
                answer+=distinctWays(i);
            }
        }
        distinctWaysGrid.put(startIndex, answer);
        return answer;
    }
}
