package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2551Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "1,3,5,1; 2; 4",
        "1,3; 2; 0"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _weights,
        int _nbBags,
        long _expectedResult) {

        assertEquals(_expectedResult, new Problem2551().putMarbles(_weights, _nbBags));
    }

}
