package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem1431Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], extra {1} --> [{2}]")
    @CsvSource(delimiter = ';', value = {
        "2,3,5,1,3; 3; true,true,true,false,true",
        "4,2,1,1,2; 1; true,false,false,false,false",
        "12,1,12; 10; true,false,true"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _candies,
        int _extraCandies,
        @ConvertWith(CsvToBooleanList.class) List<Boolean> _expectedResult) {

        assertEquals(_expectedResult, Problem1431.kidsWithCandies(_candies, _extraCandies));
    }

}
