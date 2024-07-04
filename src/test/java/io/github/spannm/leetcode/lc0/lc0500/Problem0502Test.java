package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0502Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] proj={0}, cap={1}, profits=[{2}], capital=[{3}]: {4}")
    @CsvSource(delimiter = ';', value = {
        "2; 0; 1,2,3; 0,1,1; 4",
        "3; 0; 1,2,3; 0,1,2; 6",
        "1; 0; 1,2,3; 1,1,2; 0"
    })
    void test(
        int _maxProjects,
        int _intialCapital,
        @ConvertWith(CsvToIntArray.class) int[] _arrProfits,
        @ConvertWith(CsvToIntArray.class) int[] _arrCapital,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem0502().findMaximizedCapital(
            _maxProjects, _intialCapital, _arrProfits, _arrCapital));
    }

}
