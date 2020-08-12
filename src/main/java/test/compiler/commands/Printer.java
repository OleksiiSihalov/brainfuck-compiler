package test.compiler.commands;

import test.compiler.Memory;

import java.util.List;
import java.util.Stack;

public class Printer implements Command {

    private final Memory memory;
    private final StringBuilder output;

    public Printer(Memory memory, StringBuilder output) {
        this.memory = memory;
        this.output = output;
    }

    public void addCommandToQueue(List<Command> queue, Stack<Loop> loopStack) {
        if (loopStack.empty()) {
            queue.add(this);
        } else {
            loopStack.peek().addCommandToLoop(this);
        }
    }

    public void execute() {
        short currentCell = memory.getCurrentCell();
        output.append((char) currentCell);
    }
}
