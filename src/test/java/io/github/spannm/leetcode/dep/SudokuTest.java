package io.github.spannm.leetcode.dep;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

class SudokuTest extends LeetcodeBaseTest {

    static final Arguments BOARD1           = Arguments.of("Board1", """
         [9,.,3,5,.,.,4,2,.]
        ,[.,5,.,1,7,.,.,8,.]
        ,[6,.,.,3,.,.,.,.,5]
        ,[.,.,2,.,.,.,5,9,8]
        ,[5,.,.,2,9,1,7,6,.]
        ,[4,.,.,6,5,8,.,.,.]
        ,[.,4,.,.,.,.,.,7,.]
        ,[.,2,6,.,.,5,3,4,.]
        ,[8,9,.,.,3,7,2,5,.]""", """
         [9,1,3,5,8,6,4,2,7]
        ,[2,5,4,1,7,9,6,8,3]
        ,[6,8,7,3,2,4,9,1,5]
        ,[1,6,2,7,4,3,5,9,8]
        ,[5,3,8,2,9,1,7,6,4]
        ,[4,7,9,6,5,8,1,3,2]
        ,[3,4,5,9,6,2,8,7,1]
        ,[7,2,6,8,1,5,3,4,9]
        ,[8,9,1,4,3,7,2,5,6]""");

    // https://www.conceptispuzzles.com/de/index.aspx?uri=puzzle/sudoku/techniques
    static final Arguments BOARD_CONCEPTIS1 = Arguments.of("Conceptis1", """
         [.,.,.,1,.,4,.,.,.]
        ,[.,.,1,.,.,.,9,.,.]
        ,[.,9,.,7,.,3,.,6,.]
        ,[8,.,7,.,.,.,1,.,6]
        ,[.,.,.,.,.,.,.,.,.]
        ,[3,.,4,.,.,.,5,.,9]
        ,[.,5,.,4,.,2,.,3,.]
        ,[.,.,8,.,.,.,6,.,.]
        ,[.,.,.,8,.,6,.,.,.]""", """
         [6,8,2,1,9,4,3,5,7]
        ,[7,3,1,5,6,8,9,2,4]
        ,[4,9,5,7,2,3,8,6,1]
        ,[8,2,7,9,3,5,1,4,6]
        ,[5,1,9,6,4,7,2,8,3]
        ,[3,6,4,2,8,1,5,7,9]
        ,[9,5,6,4,1,2,7,3,8]
        ,[2,4,8,3,7,9,6,1,5]
        ,[1,7,3,8,5,6,4,9,2]""");

    static final Arguments BOARD_CONCEPTIS2 = Arguments.of("Conceptis2", """
         [.,.,9,2,.,3,8,.,.]
        ,[.,.,.,.,.,9,.,.,.]
        ,[4,.,8,6,.,5,1,.,3]
        ,[1,.,2,.,.,.,9,.,4]
        ,[.,.,.,.,.,.,.,.,.]
        ,[8,.,3,.,.,.,5,.,2]
        ,[9,.,6,5,.,2,3,.,7]
        ,[.,.,1,.,.,.,.,.,.]
        ,[.,.,5,4,.,8,6,.,.]""", """
         [6,1,9,2,4,3,8,7,5]
        ,[3,5,7,1,8,9,2,4,6]
        ,[4,2,8,6,7,5,1,9,3]
        ,[1,6,2,8,5,7,9,3,4]
        ,[5,9,4,3,2,1,7,6,8]
        ,[8,7,3,9,6,4,5,1,2]
        ,[9,4,6,5,1,2,3,8,7]
        ,[2,8,1,7,3,6,4,5,9]
        ,[7,3,5,4,9,8,6,2,1]""");

    static final Arguments BOARD_HARD1      = Arguments.of("Hard1", """
         [.,2,.,.,7,.,4,.,.]
        ,[7,4,.,.,6,.,.,.,.]
        ,[.,5,.,.,.,9,.,6,.]
        ,[.,.,.,.,.,.,6,.,.]
        ,[.,.,6,.,.,.,.,3,1]
        ,[.,7,.,.,.,3,5,.,.]
        ,[.,.,.,.,9,.,2,.,4]
        ,[1,.,.,.,.,5,.,.,.]
        ,[.,.,.,.,.,.,.,.,7]""", """
         [6,2,9,3,7,8,4,1,5]
        ,[7,4,3,5,6,1,9,2,8]
        ,[8,5,1,4,2,9,7,6,3]
        ,[3,1,5,9,8,4,6,7,2]
        ,[4,9,6,2,5,7,8,3,1]
        ,[2,7,8,6,1,3,5,4,9]
        ,[5,3,7,1,9,6,2,8,4]
        ,[1,8,2,7,4,5,3,9,6]
        ,[9,6,4,8,3,2,1,5,7]""");

    static final Arguments BOARD_HARD2      = Arguments.of("Hard2", """
         [4,.,.,.,.,.,.,.,.]
        ,[.,.,.,2,1,8,.,7,.]
        ,[7,.,.,.,9,.,.,.,2]
        ,[.,.,6,.,3,.,8,.,4]
        ,[1,.,.,.,.,.,.,2,.]
        ,[.,.,5,.,.,7,.,.,.]
        ,[.,1,.,.,6,.,.,.,.]
        ,[.,6,.,.,8,5,.,.,.]
        ,[.,.,9,.,.,.,.,.,1]""", """
         [4,8,2,7,5,3,9,1,6]
        ,[6,9,3,2,1,8,4,7,5]
        ,[7,5,1,4,9,6,3,8,2]
        ,[2,7,6,5,3,1,8,9,4]
        ,[1,3,8,6,4,9,5,2,7]
        ,[9,4,5,8,2,7,1,6,3]
        ,[5,1,4,9,6,2,7,3,8]
        ,[3,6,7,1,8,5,2,4,9]
        ,[8,2,9,3,7,4,6,5,1]""");

    static final Arguments BOARD_HARD3      = Arguments.of("Hard3", """
         [.,6,.,.,.,.,4,1,5]
        ,[.,.,5,.,.,2,.,.,.]
        ,[.,.,.,.,.,.,9,.,.]
        ,[7,.,3,6,.,.,.,.,.]
        ,[2,1,8,.,.,.,.,.,.]
        ,[.,.,.,.,.,3,1,.,.]
        ,[.,.,.,4,.,8,6,.,2]
        ,[.,4,.,7,.,5,.,.,.]
        ,[.,.,.,.,.,.,.,.,9]""", """
         [9,6,2,8,3,7,4,1,5]
        ,[1,8,5,9,4,2,7,6,3]
        ,[3,7,4,1,5,6,9,2,8]
        ,[7,5,3,6,1,9,2,8,4]
        ,[2,1,8,5,7,4,3,9,6]
        ,[4,9,6,2,8,3,1,5,7]
        ,[5,3,1,4,9,8,6,7,2]
        ,[6,4,9,7,2,5,8,3,1]
        ,[8,2,7,3,6,1,5,4,9]""");

    static final Arguments BOARD_HELL1      = Arguments.of("Hell1", """
         [9,1,.,.,.,.,.,8,.]
        ,[.,.,7,9,6,.,3,.,.]
        ,[.,.,.,.,.,5,.,.,.]
        ,[.,.,6,4,3,.,9,.,.]
        ,[.,.,.,.,2,.,.,.,.]
        ,[7,.,.,.,.,.,.,.,6]
        ,[.,.,4,.,.,2,.,.,.]
        ,[.,.,.,.,.,7,5,.,.]
        ,[8,.,.,5,4,.,.,3,.]""", """
         [9,1,5,2,7,3,6,8,4]
        ,[2,8,7,9,6,4,3,5,1]
        ,[6,4,3,8,1,5,2,9,7]
        ,[1,2,6,4,3,8,9,7,5]
        ,[4,5,9,7,2,6,8,1,3]
        ,[7,3,8,1,5,9,4,2,6]
        ,[5,7,4,3,9,2,1,6,8]
        ,[3,9,1,6,8,7,5,4,2]
        ,[8,6,2,5,4,1,7,3,9]""");

    static final Arguments BOARD_LEETCODE36 = Arguments.of("Leetcode36", """
         [5,3,.,.,7,.,.,.,.]
        ,[6,.,.,1,9,5,.,.,.]
        ,[.,9,8,.,.,.,.,6,.]
        ,[8,.,.,.,6,.,.,.,3]
        ,[4,.,.,8,.,3,.,.,1]
        ,[7,.,.,.,2,.,.,.,6]
        ,[.,6,.,.,.,.,2,8,.]
        ,[.,.,.,4,1,9,.,.,5]
        ,[.,.,.,.,8,.,.,7,9]""", """
         [5,3,4,6,7,8,9,1,2]
        ,[6,7,2,1,9,5,3,4,8]
        ,[1,9,8,3,4,2,5,6,7]
        ,[8,5,9,7,6,1,4,2,3]
        ,[4,2,6,8,5,3,7,9,1]
        ,[7,1,3,9,2,4,8,5,6]
        ,[9,6,1,5,3,7,2,8,4]
        ,[2,8,7,4,1,9,6,3,5]
        ,[3,4,5,2,8,6,1,7,9]""");

    @ParameterizedTest(name = "[{index}] {0} --> {2}")
    @ArgumentsSource(BoardsProvider.class)
    @Disabled
    void test(String _name,
        @ConvertWith(CsvToCharMatrix.class) char[][] _input,
        @ConvertWith(CsvToCharMatrix.class) char[][] _solution) {

        Sudoku.Solver solver = new Sudoku.Solver(true);

        Sudoku.Board inputBoard = new Sudoku.Board(_name, _input);
        solver.solve(inputBoard);

        System.out.println(inputBoard.toString("", ""));

        assertTrue(inputBoard.isSolved());

        if (_solution.length != 0) {
            Sudoku.Board solutionBoard = new Sudoku.Board(_name + "_solution", _solution);
            assertEquals(solutionBoard, inputBoard);
        }
    }

    @Test
    void test() {
        String str = BOARD1.get()[1].toString();
        char[][] converted = new CsvToCharMatrix().convert(str, char[][].class);
        Sudoku.Board board = new Sudoku.Board(getClass().getSimpleName(), converted);
        String asciiBoard = Sudoku.AsciiBoard.draw(board);
        System.out.println(asciiBoard);
    }

    static class BoardsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext _context) {
            return Stream.of(
                BOARD1,
                BOARD_CONCEPTIS1,
                BOARD_CONCEPTIS2,
                BOARD_HARD1,
                BOARD_HARD2,
                BOARD_HARD3,
                BOARD_HELL1,
                BOARD_LEETCODE36
            );
        }
    }

}
