package test.compiler.commands;

import test.compiler.Memory;

import java.util.ArrayList;
import java.util.List;

public class Loop implements Command {

    private final Memory memory;
    private final List<Command> commands = new ArrayList<>();

    public Loop(Memory memory) {
        this.memory = memory;
    }

    public void addCommand(Command command) {
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
