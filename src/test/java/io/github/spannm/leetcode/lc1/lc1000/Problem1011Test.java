package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem1011Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "Ship [{index}] [{0}] in {1} days: {2}")
    @CsvSource(delimiter = ';', value = {
        "1,2,3,4,5,6,7,8,9,10; 5; 15",
        "3,2,2,4,1,4; 3; 6",
        "1,2,3,1,1; 4; 3",
        "1; 2; 1",
        "9, 8, 10; 3; 10"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _weights,
        int _days,
        int _expectedCapacity) {

        assertEquals(_expectedCapacity, new Problem1011().shipWithinDays(_weights, _days));
    }

}
