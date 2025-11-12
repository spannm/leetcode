package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.support.ParameterDeclarations;

import java.util.stream.Stream;

class Problem0036Test extends LeetcodeBaseTest {

    @Disabled("Work in progress")
    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @ArgumentsSource(SudokuArgumentsProvider.class)
    void test(@ConvertWith(CsvToCharMatrix.class) char[][] _sudoku, boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0036().isValidSudoku(_sudoku));
    }

    static class SudokuArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<Arguments> provideArguments(ParameterDeclarations _parameters, ExtensionContext _context) {
            return Stream.of(
                Arguments.of("""
                    [[5,3,.,.,7,.,.,.,.]
                    ,[6,.,.,1,9,5,.,.,.]
                    ,[.,9,8,.,.,.,.,6,.]
                    ,[8,.,.,.,6,.,.,.,3]
                    ,[4,.,.,8,.,3,.,.,1]
                    ,[7,.,.,.,2,.,.,.,6]
                    ,[.,6,.,.,.,.,2,8,.]
                    ,[.,.,.,4,1,9,.,.,5]
                    ,[.,.,.,.,8,.,.,7,9]]""", true),
                Arguments.of("""
                    [[8,3,.,.,7,.,.,.,.]
                    ,[6,.,.,1,9,5,.,.,.]
                    ,[.,9,8,.,.,.,.,6,.]
                    ,[8,.,.,.,6,.,.,.,3]
                    ,[4,.,.,8,.,3,.,.,1]
                    ,[7,.,.,.,2,.,.,.,6]
                    ,[.,6,.,.,.,.,2,8,.]
                    ,[.,.,.,4,1,9,.,.,5]
                    ,[.,.,.,.,8,.,.,7,9]]""", false)
            );
        }
    }

}
