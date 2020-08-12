package test.compiler.commands;

import java.util.List;
import java.util.Stack;

public interface Command {
    void addCommandToQueue(List<Command> queue, Stack<Loop> loopStack);
    void execute();
}
