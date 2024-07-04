package io.github.spannm.leetcode.lc0.lc0000;

import static org.assertj.core.api.Assertions.assertThatList;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0017Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> [{1}]")
    @CsvSource(delimiter = ';', value = {
        "23; ad,ae,af,bd,be,bf,cd,ce,cf",
        "''; ''",
        "2; a,b,c"
    })
    void test(
        String _digits,
        @ConvertWith(CsvToStringArray.class) String[] _expectedResult) {

        List<String> actualResult = new Problem0017().letterCombinations(_digits);
        assertThatList(actualResult).containsExactlyInAnyOrder(_expectedResult);
    }

}
