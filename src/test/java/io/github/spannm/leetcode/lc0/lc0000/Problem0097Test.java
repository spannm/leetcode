package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0097Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, {1}, {2} = {3}")
    @CsvSource(delimiter = ';', value = {
        "aabcc; dbbca; aadbbcbcac; true",
        "aabcc; dbbca; aadbbbaccc; false",
        "'';'';'';true",
        "ab;bc;abcb;true"
    })
    void test(String _s1, String _s2, String _s3, boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0097().isInterleave(_s1, _s2, _s3));
    }

}
