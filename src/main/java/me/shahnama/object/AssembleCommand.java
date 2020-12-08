package me.shahnama.object;

public class AssembleCommand {

    public static class INSTRUCTION_LIST {
        public static final String ACCUMULATE = "acc";
        public static final String JUMP = "jmp";
        public static final String NOPE = "nop";
    }

    public String instruction;
    public int instructionValue;
    public boolean isExecuted ;

    public AssembleCommand(String instruction, int instructionValue) {
        this.instruction = instruction;
        this.instructionValue = instructionValue;
        this.isExecuted = false;
    }

    @Override
    public String toString() {
        return "AssembleCommand{" +
                 instruction + ' ' +
                instructionValue +
                '}';
    }
}
