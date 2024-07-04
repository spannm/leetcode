package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0072Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] \"{0}\" --> \"{1}\" = {2}")
    @CsvSource(delimiter = ';', value = {
        "horse; ros; 3",
        "intention; execution; 5",
        "Markus; Markus; 0",
        "'Markus'; ''; 6"
    })
    void test(String _word1, String _word2, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0072().minDistance(_word1, _word2));
    }

}
