package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1768Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] \"{0}\", \"{1}\" --> \"{2}\"")
    @CsvSource(delimiter = ';', ignoreLeadingAndTrailingWhitespace = false, nullValues = {"null", "NULL"}, value = {
        "abc;pqr;apbqcr",
        "ab;pqrs;apbqrs",
        "'';'';''",
        " ABC ;; ABC "
    })
    void test(
        String _word1,
        String _word2,
        String _expectedResult) {

        assertEquals(_expectedResult, new Problem1768().mergeAlternately(_word1, _word2));
    }

}
