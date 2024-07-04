package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0990Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "a==b, b!=a; false",
        "b==a, a==b; true"
    })
    void test(@ConvertWith(CsvToStringArray.class) String[] _equations, boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0990().equationsPossible(_equations));
    }
}
