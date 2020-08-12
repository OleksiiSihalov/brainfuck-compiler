package test.compiler.commands;

import test.compiler.Memory;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Loop implements Command {

    private final Memory memory;
    private final List<Command> commands = new ArrayList<>();

    public Loop(Memory memory) {
        this.memory = memory;
    }

    public void addCommandToQueue(List<Command> queue, Stack<Loop> loopStack) {
        if (loopStack.empty()) {
            queue.add(this);
        } else {
            loopStack.peek().addCommandToLoop(this);
        }
        loopStack.push(this);
    }

    public void addCommandToLoop(Command command) {
        commands.add(command);
    }

    public void execute() {
        while (memory.getCurrentCell() != 0) {
            for (Command command : commands) {
                command.execute();
            }
        }
    }
}
