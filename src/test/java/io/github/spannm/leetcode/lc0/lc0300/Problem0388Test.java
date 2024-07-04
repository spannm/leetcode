package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0388Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "'dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext'; 20",
        "'dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext'; 32",
        "'a'; 0"
    })
    void test(String _input, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0388().lengthLongestPath(_input));
    }

}
