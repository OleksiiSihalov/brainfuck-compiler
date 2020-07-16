package test.compiler.commands;

import test.compiler.Memory;

public class Printer implements Command {

    private final Memory memory;
    private final StringBuilder output;

    public Printer(Memory memory, StringBuilder output) {
        this.memory = memory;
        this.output = output;
    }

    public void execute() {
        short currentCell = memory.getCurrentCell();
        output.append((char) currentCell);
        //System.out.print((char) currentCell);
    }
}
