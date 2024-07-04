package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0946Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,4,5; 4,5,3,2,1; true",
        "1,2,3,4,5; 4,3,5,1,2; false"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _pushed,
        @ConvertWith(CsvToIntArray.class) int[] _popped,
        boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0946().validateStackSequences(_pushed, _popped));
    }

}
