package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0189Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], steps {1} --> [{2}]")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,4,5,6,7; 3; 5,6,7,1,2,3,4",
        "-1,-100,3,99; 2; 3,99,-1,-100",
        "1,2,3,4; 0; 1,2,3,4",
        "1,2,3,4; 400; 1,2,3,4",
    })

    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        int _steps,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {

        new Problem0189().rotate(_nums, _steps);
        assertArrayEquals(_expectedResult, _nums);

    }

}
