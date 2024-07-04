package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem0068Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, {1} --> {2}")
    @CsvSource(delimiter = ';', quoteCharacter = '"', ignoreLeadingAndTrailingWhitespace = false, value = {
        "This,is, an, example, of, text, justification.;16;This    is    an,example  of text,justification.  ",
        "What,must,be,acknowledgment,shall,be;16;What   must   be,acknowledgment  ,shall be        ",
        "Science,is,what,we,understand,well,enough,to,explain,to,a,computer.,Art,is,everything,else,we,do;20;"
        + "Science  is  what we,understand      well,enough to explain to,a  computer.  Art is,everything  else  we,do                  "
    })
    void test(
        @ConvertWith(CsvToStringArray.class) String[] _words,
        int _maxWidth,
        String _expectedCsv) {

        List<Object> expectedList = Arrays.asList(_expectedCsv.split(","));
        assertEquals(expectedList, new Problem0068().fullJustify(_words, _maxWidth));
    }

}
