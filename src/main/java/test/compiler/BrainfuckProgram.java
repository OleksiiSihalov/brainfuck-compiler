package test.compiler;

import test.compiler.commands.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BrainfuckProgram {

    private final Memory memory;
    private final StringBuilder output = new StringBuilder();
    private final List<Command> commandQueue = new ArrayList<>();

    public BrainfuckProgram(Memory memory, String input) {
        this.memory = memory;
        addCommands(input);
    }

    private void addCommands(String input) {
        char[] charInput = input.toCharArray();
        Stack<Loop> loopStack = new Stack<>();
        for (char c : charInput) {
            Command command = null;
            switch (c) {
                case '>':
                    command = new PointerMover(memory, +1);
                    break;
                case '<':
                    command = new PointerMover(memory, -1);
                    break;
                case '+':
                    command = new ValueChanger(memory, +1);
                    break;
                case '-':
                    command = new ValueChanger(memory, -1);
                    break;
                case '.':
                    command = new Printer(memory, output);
                    break;
                case '[':
                    command = new Loop(memory);
                    break;
                case ']':
                    if (loopStack.empty()) {
                        throw new IllegalArgumentException("'[' expected");
                    }
                    loopStack.pop();
                    break;
                default:
                    if (c == '\r' || c == '\n' || c == '\t' || c == ' ') {
                        break;
                    }
                    throw new UnsupportedOperationException("Unsupported operation '" + c + "' index: " + input.indexOf(c));
            }
            if (command != null) {
                command.addCommandToQueue(commandQueue, loopStack);
            }
        }
        if (!loopStack.empty()) {
            throw new IllegalArgumentException("']' expected");
        }
    }

    public String interpret() {
        for (Command command : commandQueue) {
            command.execute();
        }
        return output.toString();
    }

}
