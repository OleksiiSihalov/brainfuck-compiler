package test.compiler.commands;

import test.compiler.Memory;

public class PointerMover implements Command {

    private final Memory memory;
    private final int augment;

    public PointerMover(Memory memory, int augment) {
        this.memory = memory;
        this.augment = augment;
    }

    public void execute() {
        memory.movePointer(augment);
    }

}
