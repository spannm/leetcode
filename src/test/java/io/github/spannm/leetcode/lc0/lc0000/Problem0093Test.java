package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0093Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "25525511135; 255.255.11.135,255.255.111.35",
        "0000; 0.0.0.0",
        "101023; 1.0.10.23,1.0.102.3,10.1.0.23,10.10.2.3,101.0.2.3"
    })
    void test(
        String _s,
        @ConvertWith(CsvToStringList.class) List<String> _expectedResult) {
        assertEquals(_expectedResult, new Problem0093().restoreIpAddresses(_s));
    }

}
