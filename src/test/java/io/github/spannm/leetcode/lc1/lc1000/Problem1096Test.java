package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem1096Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "{a,b}{c,{d,e}}; ac,ad,ae,bc,bd,be",
        "{{a,z},a{b,c},{ab,z}}; a,ab,ac,z"
    })
    void test(String _expr,
        @ConvertWith(LeetcodeBaseTest.CsvToStringList.class) List<String> _expectedResult) {
        assertEquals(_expectedResult, new Problem1096().braceExpansionII(_expr));
    }

}
