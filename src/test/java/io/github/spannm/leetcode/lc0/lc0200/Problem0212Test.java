package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0212Test extends LeetcodeBaseTest {
    @ParameterizedTest(name = "[{index}] {0}; {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "[o,a,a,n],[e,t,a,e],[i,h,k,r],[i,f,l,v]; oath,pea,eat,rain; eat,oath",
        "[a,b],[c,d]; abcb; "
    })
    void test(
        @ConvertWith(CsvToCharMatrix.class) char[][] _board,
        @ConvertWith(CsvToStringArray.class) String[] _words,
        @ConvertWith(CsvToStringList.class) List<String> _expectedResult) {
        assertEquals(_expectedResult, new Problem0212().findWords(_board, _words));
    }
}
