package io.github.spannm.leetcode.lc0.lc0200;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0260Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "1,2,1,3,2,5; 3,5",
        "-1,0; -1,0",
        "0,1; 1,0"
    })
    void test(
        @ConvertWith(CsvToIntArray.class) int[] _nums,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {

        assertThat(new Problem0260().singleNumber(_nums)).containsExactlyInAnyOrder(_expectedResult);
    }

}
