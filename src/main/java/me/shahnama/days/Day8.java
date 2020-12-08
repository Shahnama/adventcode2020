package me.shahnama.days;

import me.shahnama.object.AssembleCommand;
import me.shahnama.object.ProgramHaltMessage;
import me.shahnama.tools.AnswerNotFindException;
import me.shahnama.tools.Tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day8 {
    private final String PUZZLE_INPUT;
    private List<String> puzzleInput;

    private HashMap<Integer, AssembleCommand> program = null;
    private List<Integer> nopeJumpLineNumber;

    public Day8(String PUZZLE_INPUT){
        this.PUZZLE_INPUT = PUZZLE_INPUT;
        readInput();
        loadProgram();
    }
    private void readInput(){
        puzzleInput = new Tools().readInput(PUZZLE_INPUT);
    }

    public int solve_P1() throws AnswerNotFindException {
        return runProgram().accumulator;
    }

    public int solve_P2() throws AnswerNotFindException {
        int accumulator= -1;
        for(int lineNumber : nopeJumpLineNumber) {
            swapNopeJumpCode(lineNumber);
            ProgramHaltMessage programHaltMessage = runProgram();
            if(programHaltMessage.haltCode == ProgramHaltMessage.TERMINATES){
                accumulator = programHaltMessage.accumulator;
                break;
            }
            loadProgram();
        }
        return accumulator;
    }

    private void swapNopeJumpCode(int lineNumber){
        AssembleCommand assembleCommand = program.get(lineNumber);
        String instruction = assembleCommand.instruction;

        if(AssembleCommand.INSTRUCTION_LIST.JUMP.equals(instruction)){
            program.get(lineNumber).instruction = AssembleCommand.INSTRUCTION_LIST.NOPE ;
        }else if(AssembleCommand.INSTRUCTION_LIST.NOPE.equals(instruction)){
            program.get(lineNumber).instruction = AssembleCommand.INSTRUCTION_LIST.JUMP ;
        }
    }

    private ProgramHaltMessage runProgram() throws AnswerNotFindException {
        int nextLine = 0;
        int accumulatorValue = 0;
        int haltCode;
        while(true){
            AssembleCommand assembleCommand = program.get(nextLine);
            String instruction = assembleCommand.instruction;

            if(assembleCommand.isExecuted){
                haltCode = ProgramHaltMessage.INFINITE_LOOP;
                break;
            }
            assembleCommand.isExecuted = true;
            if(AssembleCommand.INSTRUCTION_LIST.ACCUMULATE.equals(instruction)){
                accumulatorValue+=assembleCommand.instructionValue;
                nextLine++;
            }else if(AssembleCommand.INSTRUCTION_LIST.JUMP.equals(instruction)){
                nextLine+= assembleCommand.instructionValue;
            }else if(AssembleCommand.INSTRUCTION_LIST.NOPE.equals(instruction)){
                nextLine++;
            }else{
                throw new AnswerNotFindException("Unsupported instruction command");
            }
            if(nextLine==program.size()){
                haltCode = ProgramHaltMessage.TERMINATES;
                break;
            }
        }
        return new ProgramHaltMessage(haltCode,accumulatorValue);
    }

    private void loadProgram(){
        int lineNumber = 0;
        nopeJumpLineNumber = new ArrayList<>();
        program = new HashMap<>();
        for(String data:puzzleInput ){
            String[] dataArray = data.split(" ");
            String instruction =  dataArray[0];
            int instructionValue = Integer.parseInt(dataArray[1]);
            program.put(lineNumber,new AssembleCommand(instruction,instructionValue));
            if(AssembleCommand.INSTRUCTION_LIST.JUMP.equals(instruction) ||
                    AssembleCommand.INSTRUCTION_LIST.NOPE.equals(instruction)
            ){
                nopeJumpLineNumber.add(lineNumber);
            }
            lineNumber++;
        }
    }
}
