package test.compiler;

import test.compiler.commands.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BrainfuckProgram {

    private final Memory memory;
    private final StringBuilder output = new StringBuilder();
    private final List<Command> commands = new ArrayList<>();

    public BrainfuckProgram(Memory memory, String input) {
        this.memory = memory;
        addCommands(input);
    }

    private void addCommands(String input) {
        char[] charInput = input.toCharArray();
        Stack<Loop> loopStack = new Stack<>();
        for (char c : charInput) {
            switch (c) {
                case '>':
                    addCommand(new PointerMover(memory, +1), loopStack);
                    break;
                case '<':
                    addCommand(new PointerMover(memory, -1), loopStack);
                    break;
                case '+':
                    addCommand(new ValueChanger(memory, +1), loopStack);
                    break;
                case '-':
                    addCommand(new ValueChanger(memory, -1), loopStack);
                    break;
                case '.':
                    addCommand(new Printer(memory, output), loopStack);
                    break;
                case '[':
                    addCommand(new Loop(memory), loopStack);
                    break;
                case ']':
                    if (loopStack.empty()) {
                        throw new IllegalArgumentException ("'[' expected");
                    }
                    loopStack.pop();
                    break;
                default:
                    if (c == '\r' || c == '\n' || c == '\t' || c == ' ') {
                        break;
                    }
                    throw new UnsupportedOperationException("Unsupported operation '" + c + "' index: " + input.indexOf(c));
            }
        }
        if (!loopStack.empty()) {
            throw new IllegalArgumentException ("']' expected");
        }
    }

    private void addCommand(Command command, Stack<Loop> loopStack) {
        if (loopStack.empty()) {
            commands.add(command);
        } else {
            loopStack.peek().addCommand(command);
        }
        if (command instanceof Loop)
            loopStack.push((Loop) command);
    }

    public String interpret() {
        for (Command command : commands) {
            command.execute();
        }
        return output.toString();
    }

}
