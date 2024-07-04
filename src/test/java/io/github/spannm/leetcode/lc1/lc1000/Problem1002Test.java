package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem1002Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "bella,label,roller; e,l,l",
        "cool,lock,cook; c,o"
    })
    void test(@ConvertWith(CsvToStringArray.class) String[] _arr,
        @ConvertWith(CsvToStringList.class) List<String> _expectedResult) {
        assertEquals(_expectedResult, new Problem1002().commonChars(_arr));
    }

}
