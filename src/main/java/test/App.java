package test;

import test.compiler.Compiler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Brainfuck Program:");
        String input = reader.readLine();

        Compiler compiler;
        String output = "";
        try {
            compiler = new Compiler(input);
            output = compiler.compile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Brainfuck Program output:");
        System.out.println(output);
    }
}
