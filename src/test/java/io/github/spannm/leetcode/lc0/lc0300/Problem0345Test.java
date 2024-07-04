package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0345Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] \"{0}\" --> \"{1}\"")
    @CsvSource(delimiter = ';', value = {
        "hello; holle",
        "leetcode; leotcede",
        "''; ''",
        "a; a",
        "abbA; Abba",
        "aeiou; uoiea"
    })
    void test(String _input, String _expectedResult) {
        assertEquals(_expectedResult, new Problem0345().reverseVowels(_input));
    }

}
