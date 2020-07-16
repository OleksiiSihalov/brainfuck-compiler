package test.compiler;

public class Memory {

    private final int MEMORY_SIZE = 30000;
    private final byte[] memory = new byte[MEMORY_SIZE];
    private int pointer = 0;

    public short getCurrentCell() {
        return memory[pointer];
    }

    public void movePointer(int arg) {
        if(pointer + arg < MEMORY_SIZE){
            pointer += arg;
        }
    }

    public void changeValue(int arg) {
        memory[pointer] += arg;
    }

}
