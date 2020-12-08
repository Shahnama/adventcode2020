package me.shahnama.object;

public class ProgramHaltMessage {

    public static final int INFINITE_LOOP = -1;
    public static final int TERMINATES = 0;

    public final int haltCode;
    public final int accumulator;

    public ProgramHaltMessage(int haltCode, int accumulator) {
        this.haltCode = haltCode;
        this.accumulator = accumulator;
    }
}
