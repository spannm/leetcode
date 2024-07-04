package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0819Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, [{1}] --> {2}")
    @CsvSource(delimiter = ';', value = {
        "Bob hit a ball, the hit BALL flew far after it was hit.; hit; ball",
        "a.; ; a",
        "a, a, a, a, b,b,b,c, c; a; b"
    })
    void test(
        String _paragraph,
        @ConvertWith(CsvToStringArray.class) String[] _banned,
        String _expectedResult) {

        assertEquals(_expectedResult, new Problem0819().mostCommonWord(_paragraph, _banned));
    }

}
