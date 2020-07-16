package test.compiler;

import org.junit.Assert;
import org.junit.Test;

public class CompilerTest {

    @Test(expected = UnsupportedOperationException.class)
    public void testUnsupportedOperationException() {

        String program = ",.,.,.";
        Compiler compiler = new Compiler(program);
    }

    @Test(expected = RuntimeException.class)
    public void testIncorrectBracketException() {
        String program = "++++++++>+>++++<<-]>++>>+<[-[>>+<<-]+>>]>+[\n" +
                "    -<<<[\n" +
                "        ->[+[-]+>++>>>-<<]<[<]>>++++++[<<+++++>>-]+<<++.[-]<<\n" +
                "    ]>.>+[>>]>+\n" +
                "]";
        Compiler compiler = new Compiler(program);
    }

    @Test
    public void testCompile() {
        //Shows an ASCII representation of the Sierpinski triangle
        String program = "++++++++[>+>++++<<-]>++>>+<[-[>>+<<-]+>>]>+[\n" +
                "    -<<<[\n" +
                "        ->[+[-]+>++>>>-<<]<[<]>>++++++[<<+++++>>-]+<<++.[-]<<\n" +
                "    ]>.>+[>>]>+\n" +
                "]";    //++++++++[>+>++++<<-]>++>>+<[-[>>+<<-]+>>]>+[ -<<<[ ->[+[-]+>++>>>-<<]<[<]>>++++++[<<+++++>>-]+<<++.[-]<< ]>.>+[>>]>+ ]

        String expected =
                "                               *\n" +
                        "                              * *\n" +
                        "                             *   *\n" +
                        "                            * * * *\n" +
                        "                           *       *\n" +
                        "                          * *     * *\n" +
                        "                         *   *   *   *\n" +
                        "                        * * * * * * * *\n" +
                        "                       *               *\n" +
                        "                      * *             * *\n" +
                        "                     *   *           *   *\n" +
                        "                    * * * *         * * * *\n" +
                        "                   *       *       *       *\n" +
                        "                  * *     * *     * *     * *\n" +
                        "                 *   *   *   *   *   *   *   *\n" +
                        "                * * * * * * * * * * * * * * * *\n" +
                        "               *                               *\n" +
                        "              * *                             * *\n" +
                        "             *   *                           *   *\n" +
                        "            * * * *                         * * * *\n" +
                        "           *       *                       *       *\n" +
                        "          * *     * *                     * *     * *\n" +
                        "         *   *   *   *                   *   *   *   *\n" +
                        "        * * * * * * * *                 * * * * * * * *\n" +
                        "       *               *               *               *\n" +
                        "      * *             * *             * *             * *\n" +
                        "     *   *           *   *           *   *           *   *\n" +
                        "    * * * *         * * * *         * * * *         * * * *\n" +
                        "   *       *       *       *       *       *       *       *\n" +
                        "  * *     * *     * *     * *     * *     * *     * *     * *\n" +
                        " *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *\n" +
                        "* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n";

        Compiler compiler = new Compiler(program);

        String actual = compiler.compile();
        Assert.assertEquals(expected, actual);
    }
}