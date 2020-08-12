package test.compiler.commands;

import test.compiler.Memory;

import java.util.List;
import java.util.Stack;

public class ValueChanger implements Command {

    private final Memory memory;
    private final int augment;

    public ValueChanger(Memory memory, int augment) {
        this.memory = memory;
        this.augment = augment;
    }

    public void addCommandToQueue(List<Command> queue, Stack<Loop> loopStack) {
        if (loopStack.empty()) {
            queue.add(this);
        } else {
            loopStack.peek().addCommandToLoop(this);
        }
    }

    public void execute() {
        memory.changeValue(augment);
    }
}
