package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem1630Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}], [{1}], [{2}] --> [{3}]")
    @CsvSource(delimiter = ';', value = {
        "4,6,5,9,3,7; 0,0,2; 2,3,5; true,false,true",
        "-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10; 0,1,6,4,8,7; 4,4,9,7,9,10; false,true,false,false,true,true"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        @ConvertWith(CsvToIntArray.class) int[] _l,
        @ConvertWith(CsvToIntArray.class) int[] _r,
        @ConvertWith(CsvToBooleanList.class) List<Boolean> _expectedResult) {

        assertEquals(_expectedResult, new Problem1630().checkArithmeticSubarrays(_nums, _l, _r));
    }

}
