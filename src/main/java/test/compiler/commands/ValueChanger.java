package test.compiler.commands;

import test.compiler.Memory;

public class ValueChanger implements Command {

    private final Memory memory;
    private final int augment;

    public ValueChanger(Memory memory, int augment) {
        this.memory = memory;
        this.augment = augment;
    }

    public void execute() {
        memory.changeValue(augment);
    }
}
