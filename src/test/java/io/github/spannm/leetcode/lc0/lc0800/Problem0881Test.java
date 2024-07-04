package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0881Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,2; 3; 1",
        "3,2,2,1; 3; 3",
        "3,5,3,4; 5; 4"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _people,
        int _limit,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem0881().numRescueBoats(_people, _limit));
    }

}
