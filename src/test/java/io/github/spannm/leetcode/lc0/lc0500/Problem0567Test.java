package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0567Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "ab; eidbaooo; true",
        "ab; eidboaoo; false",
        "hello; ooolleoooleh; false"
    })
    void test(
        String _str1,
        String _str2,
        boolean _expectedResult) {

        assertEquals(_expectedResult, new Problem0567().checkInclusion(_str1, _str2));
    }

}
