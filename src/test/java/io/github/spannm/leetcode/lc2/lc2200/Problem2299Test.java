package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem2299Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "IloveLe3tcode!; true",
        "Me+You--IsMyDream; false",
        "1aB!; false"
    })
    void test(String _password, boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem2299().strongPasswordCheckerII(_password));
    }

}
