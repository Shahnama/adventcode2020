package me.shahnama.days;

import me.shahnama.tools.Tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day10 {
    private final String PUZZLE_INPUT;
    private List<Integer> puzzleInput;
    List<List<Integer>> result = new ArrayList<>();

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
        Collections.sort(puzzleInput);
    }

    public int solve_P1() {

        int nextAdapter = 0;
        int diff3 = 0;
        int diff2 = 0;
        int diff1 = 0;
        int max = Collections.max(puzzleInput);
        while (!puzzleInput.isEmpty()) {
            int min = Collections.min(puzzleInput);
            int dif = min - nextAdapter;
            switch (dif) {
                case 3 -> diff3++;
                case 2 -> diff2++;
                case 1 -> diff1++;
                default -> System.out.println("Error");
            }
//            System.out.printf("%s->%s %s\n", nextAdapter, min, dif);
            puzzleInput.remove(Integer.valueOf(min));
            nextAdapter = min;
        }
        diff3++;
//        System.out.printf("%s,%s\n",diff3,diff1);
        return diff1 * diff3;
    }

    public long solve_P2() {
        System.out.println(puzzleInput.size());
//        System.out.println(BigIntegerMath.factorial(puzzleInput.size()));
        List<Integer> tempResult = new ArrayList<>();
//        int nextAdapter = 0;
//        tempResult.add(0);
//        result.clear();

//        test(0, tempResult);
//        printList(test(0, tempResult));
        test2(0);

        return count;
    }

    private void printList(List<List<Integer>> list) {

//        count++;
//        System.out.print(list.size() + " ======");

        for (int i = 0; i < list.size(); i++) {
            List<Integer> tempList = list.get(i);
            for (int j = 0; j < tempList.size(); j++) {
                System.out.printf("%s ", tempList.get(j));
            }
            System.out.println();
        }
    }

    private void printList2(List<Integer> list) {

//        count++;
        System.out.print(count + " ======");

            for (int j = 0; j < list.size(); j++) {
                System.out.printf("%s ", list.get(j));
            }
            System.out.println();

    }

    private List<List<Integer>> test(int inputJolt, List<Integer> list) {
        List<Integer> nextPossible = getNextPossibleList(inputJolt);
//        System.out.print(inputJolt +" Nest Loop  ");

//        for(int i:nextPossible){
//            System.out.printf("%s ", i);
//        }
//        System.out.println();

        for (int next : nextPossible) {
            List<Integer> tempResult = new ArrayList<>();
            tempResult = getCopy(list);
//            System.out.println("next " + next);
            tempResult.add(next);

            test(next, tempResult);
//            System.out.println(  );
            if(next==Collections.max(puzzleInput)){
//                System.out.println("*********" );
//                printList(result);
                result.add(tempResult);

                count++;
                printList2(tempResult);

            }
        }
        return result;
    }

    private void test2(int inputJolt) {
        List<Integer> nextPossible = getNextPossibleList2(inputJolt);
//        System.out.print(inputJolt +" Nest Loop  ");

//        for(int i:nextPossible){
//            System.out.printf("%s ", i);
//        }
//        System.out.println();

        for (int next : nextPossible) {
//            List<Integer> tempResult = new ArrayList<>();
//            tempResult = getCopy(list);
//            System.out.println("next " + next);
//            tempResult.add(next);

            test2(next);
//            System.out.println(  );
            if(next==Collections.max(puzzleInput)){
//                System.out.println("*********" );
//                printList(result);
//                result.add(tempResult);

                count++;
//                printList2(tempResult);

            }
        }
//        return result;
    }

    private List<Integer> getNextPossibleList2(Integer inputJolt){
        List<Integer> result = new ArrayList<>();
        int startIndex = inputJolt == 0 ? 0 : puzzleInput.indexOf(inputJolt)+1;


        for(int i=startIndex;i<puzzleInput.size();i++){
            int dif = puzzleInput.get(i) - inputJolt;
//            System.out.printf("%s-%s(%s)=%s\n",inputJolt,puzzleInput.get(i),i,dif);
            if (dif < 4 ) {
                result.add(puzzleInput.get(i));
            } else {
                return result;
            }
        }
        return result;
    }

    private List<Integer> getNextPossibleList(int inputJolt) {
        List<Integer> temptResult = getCopy(puzzleInput);
        List<Integer> result = new ArrayList<>();
        while (!temptResult.isEmpty()) {
            int min = Collections.min(temptResult);
            int dif = min - inputJolt;
            if (dif<1){
                temptResult.remove(Integer.valueOf(min));
            }
            else if (dif < 4 ) {
                temptResult.remove(Integer.valueOf(min));
//                System.out.println("min " + min);
//                System.out.println(puzzleInput.size() + " " + temptResult.size());
                result.add(min);
            } else {
//                System.out.println("getNextPossibleList " + inputJolt + " " + result.size());
                return result;
            }
        }
//        System.out.println("1- getNextPossibleList " + inputJolt + " " + result.size());
        return result;
    }

    private List<Integer> getCopy(List<Integer> list) {
        List<Integer> temp = new ArrayList<>();
        for (int value : list) {
            temp.add(value);
        }
        return temp;
    }

}
