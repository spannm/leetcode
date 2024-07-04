package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0839Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] --> {1}")
    @CsvSource(delimiter = ';', value = {
        "tars,rats,arts,star; 2",
        "omv,ovm; 1"
    })
    void test(
        @ConvertWith(CsvToStringArray.class) String[] _strs,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem0839().numSimilarGroups(_strs));
    }

}
