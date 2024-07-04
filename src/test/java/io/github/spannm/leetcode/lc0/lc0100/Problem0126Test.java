package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0126Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}; {1}; {2} --> {3}")
    @CsvSource(delimiter = ';', value = {
        "hit; cog; hot,dot,dog,lot,log,cog; [hit,hot,dot,dog,cog],[hit,hot,lot,log,cog]",
        "hit; cog; hot,dot,dog,lot,log; "
    })
    void test(
        String _start, String _end,
        @ConvertWith(CsvToStringList.class) List<String> _dict,
        @ConvertWith(CsvToListOfStringLists.class) List<List<String>> _expectedResult) {
        assertEquals(_expectedResult, new Problem0126().findLadders(_start, _end, _dict));
    }

}
