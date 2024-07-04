package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0071Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] \"{0}\" --> \"{1}\"")
    @CsvSource(delimiter = ';', value = {
        "/home/;/home",
        "/../;/",
        "/../../../;/",
        "/d1/d2/d3/../../;/d1",
        "/home//foo/;/home/foo"
    })
    void test(String _path, String _expectedResult) {
        assertEquals(_expectedResult, new Problem0071().simplifyPath(_path));
    }

}
