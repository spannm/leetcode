package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0518Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, [{1}] --> {2}")
    @CsvSource(delimiter = ';', value = {
        "5; 1,2,5; 4",
        "3; 2; 0",
        "10; 10; 1"
    })
    void test(
        int _amount,
        @ConvertWith(CsvToIntArray.class) int[] _coins,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem0518().change(_amount, _coins));
    }

}
