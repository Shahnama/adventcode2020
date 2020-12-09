package me.shahnama.days;

import me.shahnama.tools.AnswerNotFindException;
import me.shahnama.tools.Tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day9 {

    private static final int SUM = 0;
    private static final int MULTIPLICATION = 1;

    private final String PUZZLE_INPUT;
    private  final int preambleLength;
    private List<Long> puzzleInput;
    private List<Long> preambleList;

    public Day9(String PUZZLE_INPUT , int preambleLength){
        this.PUZZLE_INPUT = PUZZLE_INPUT;
        this.preambleLength = preambleLength;
        readInput();
    }
    private void readInput(){
        List<String> puzzleInputString = new Tools().readInput(PUZZLE_INPUT);
        puzzleInput = new ArrayList<>();
        for(String data:puzzleInputString) {
            puzzleInput.add(Long.parseLong(data));
        }
    }

    public Long solve_P1() throws AnswerNotFindException {
        for(int index=preambleLength;index<puzzleInput.size();index++){
            loadPreambleList(index);
            if(!isSumOfPreambleList(puzzleInput.get(index))){
                return puzzleInput.get(index);
            }
        }
        return -1L;
    }

    public Long solve_P2() throws AnswerNotFindException {
        List<Long> contiguousSet = getContiguousSet(getInvalidNumber());

        long smallestNumber =  Collections.max(contiguousSet);
        long largestNumber = Collections.min(contiguousSet);

        return smallestNumber+largestNumber;
//        return -1L;

    }

    private List<Long> getContiguousSet(long invalidNumber ) {
        int indexOfInvalidNumber = puzzleInput.indexOf(invalidNumber);
        System.out.println(indexOfInvalidNumber);
        List<Long> contiguousSet = new ArrayList<>();
        if (invalidNumber == -1L) {
            return contiguousSet;
        }
        int i = -1;
        int j = -1;
        int k = -1;

        for (i = 0; i < indexOfInvalidNumber; i++) {
            contiguousSet.clear();
            long sum = puzzleInput.get(i);
            contiguousSet.add(puzzleInput.get(i));
            System.out.printf("\n%s,", puzzleInput.get(i));
            for (j = i + 1; j < indexOfInvalidNumber; j++) {
                System.out.printf("%s,", puzzleInput.get(j));
                contiguousSet.add(puzzleInput.get(j));
                sum += puzzleInput.get(j);
                if(sum == invalidNumber){
                    System.out.println();
                    return contiguousSet;
                }

            }
        }
        System.out.println();

        System.out.printf("%s,%s,%s\n", puzzleInput.get(i), puzzleInput.get(j), puzzleInput.get(k));

        return contiguousSet;
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


    private Long getInvalidNumber(){
        for(int index=preambleLength;index<puzzleInput.size();index++){
            loadPreambleList(index);
            if(!isSumOfPreambleList(puzzleInput.get(index))){
                return puzzleInput.get(index);
            }
        }
        return -1L;
    }

    private boolean isSumOfPreambleList(long data){
//        System.out.println("preambleList size: "+preambleList);
        for(int i=0;i<preambleList.size();i++){
            for(int j=i+1;j<preambleList.size();j++){
//                System.out.printf("%s %s+%s=%s\n",data,preambleList.get(i),preambleList.get(j),preambleList.get(i)+preambleList.get(j));
                if(preambleList.get(i)+preambleList.get(j)==data){
                    return true;
                }
            }
        }
        return false;
    }

    private void loadPreambleList(int startIndex){
        preambleList = new ArrayList<>();

        for(int index=startIndex-preambleLength;index<(startIndex-preambleLength)+preambleLength;index++){
            preambleList.add(puzzleInput.get(index));
        }
    }
}
