package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0067Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] \"{0}\" + \"{1}\" --> {2}")
    @CsvSource(delimiter = ';', value = {
        "11; 1; 100",
        "1010; 1011; 10101",
        "100; 110010; 110110",
        "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101;"
        + "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011; "
        + "110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000"
    })
    void test(String _input1, String _input2, String _expectedResult) {
        assertEquals(_expectedResult, new Problem0067().addBinary(_input1, _input2));
    }

}
