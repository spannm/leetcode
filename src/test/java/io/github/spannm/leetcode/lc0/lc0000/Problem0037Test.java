package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

class Problem0037Test extends LeetcodeBaseTest {

    @Disabled("Work in progress")
    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @ArgumentsSource(SudokuArgumentsProvider.class)
    void test(@ConvertWith(CsvToCharMatrix.class) char[][] _input, @ConvertWith(CsvToCharMatrix.class) char[][] _expectedResult) {
        new Problem0037().solveSudoku(_input);
        assertArrayEquals(_expectedResult, _input);
    }

    static class SudokuArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext _context) {
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
                    ,[.,.,.,.,8,.,.,7,9]]""", """
                    [[5,3,4,6,7,8,9,1,2]
                    ,[6,7,2,1,9,5,3,4,8]
                    ,[1,9,8,3,4,2,5,6,7]
                    ,[8,5,9,7,6,1,4,2,3]
                    ,[4,2,6,8,5,3,7,9,1]
                    ,[7,1,3,9,2,4,8,5,6]
                    ,[9,6,1,5,3,7,2,8,4]
                    ,[2,8,7,4,1,9,6,3,5]
                    ,[3,4,5,2,8,6,1,7,9]]"""),
                Arguments.of("""
                    [[.,.,9,7,4,8,.,.,.]
                    ,[7,.,.,.,.,.,.,.,.]
                    ,[.,2,.,1,.,9,.,.,.]
                    ,[.,.,7,.,.,.,2,4,.]
                    ,[.,6,4,.,1,.,5,9,.]
                    ,[.,9,8,.,.,.,3,.,.]
                    ,[.,.,.,8,.,3,.,2,.]
                    ,[.,.,.,.,.,.,.,.,6]
                    ,[.,.,.,2,7,5,9,.,.]]""", """
                    [[5,1,9,7,4,8,6,3,2]
                    ,[7,8,3,6,5,2,4,1,9]
                    ,[4,2,6,1,3,9,8,7,5]
                    ,[3,5,7,9,8,6,2,4,1]
                    ,[2,6,4,3,1,7,5,9,8]
                    ,[1,9,8,5,2,4,3,6,7]
                    ,[9,7,5,8,6,3,1,2,4]
                    ,[8,3,2,4,9,1,7,5,6]
                    ,[6,4,1,2,7,5,9,8,3]]""")
            );
        }
    }

}
