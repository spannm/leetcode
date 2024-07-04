package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0648Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "cat,bat,rat; the cattle was rattled by the battery; the cat was rat by the bat",
        "a,b,c; aadsfasf absbs bbab cadsfafs; a a b c"
    })
    void test(@ConvertWith(CsvToStringList.class) List<String> _dict, String _sentence, String _expectedResult) {
        assertEquals(_expectedResult, new Problem0648().replaceWords(_dict, _sentence));
    }
}
