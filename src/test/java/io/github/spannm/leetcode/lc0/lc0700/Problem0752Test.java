package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0752Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "0201,0101,0102,1212,2002; 0202; 6",
        "8888; 0009; 1",
        "8887,8889,8878,8898,8788,8988,7888,9888; 8888; -1"
    })
    void test(@ConvertWith(CsvToStringArray.class) String[] _deadends, String _target, int _expectedResult) {
        assertEquals(_expectedResult, new Problem0752().openLock(_deadends, _target));
    }

}
