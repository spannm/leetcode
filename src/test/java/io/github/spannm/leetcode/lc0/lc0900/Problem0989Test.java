package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0989Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] + {1} --> [{2}]")
    @CsvSource(delimiter = ';', value = {
        "1,2,0,0; 34; 1,2,3,4",
        "2,7,4; 181; 4,5,5",
        "2,1,5; 806; 1,0,2,1",
        "9,9,9,9,9,9,9,9,9,9; 1; 1,0,0,0,0,0,0,0,0,0,0",
        "[1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3]; 516; [1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,5,7,9]"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _num,
        int _k,
        @ConvertWith(CsvToIntegerList.class) List<Integer> _expectedResult) {

        assertEquals(_expectedResult, new Problem0989().addToArrayForm(_num, _k));
    }

}
