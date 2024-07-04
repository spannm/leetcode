package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1850Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "5489355142; 4; 2",
        "11112; 4; 4",
        "00123; 1; 1"
    })
    void test(String num, int k, int _expectedResult) {
        assertEquals(_expectedResult, new Problem1850().getMinSwaps(num, k));
    }

}
