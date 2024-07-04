package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0028Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] haystack={0}, needle={1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "sadbutsad; sad; 0",
        "leetcode; leeto; -1",
        "haystack; longneedle; -1",
        "needle; needle; 0",
        "ABC; abc; -1"
    })

    void test(
        String _haystack,
        String _needle,
        int _expectedResult) {
        assertEquals(_expectedResult, new Problem0028().strStr(_haystack, _needle));
    }

}
