package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0242Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} vs. {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "anagram; nagaram; true",
        "rat; car; false"
    })

    void test(
        String _s,
        String _t,
        boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0242().isAnagram(_s, _t));
    }

}
