package test.compiler;

public class Compiler {
    private final BrainfuckProgram brainfuckProgram;

    public Compiler(String input) {
        Memory memory = new Memory();
        this.brainfuckProgram = new BrainfuckProgram(memory, input);
    }

    public String compile() {
        return brainfuckProgram.interpret();
    }
}
