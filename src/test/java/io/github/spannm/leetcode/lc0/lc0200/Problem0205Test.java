package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0205Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} / {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "egg; add; true",
        "foo; bar; false",
        "paper; title; true",
        "badc; baba; false"
    })

    void test(
        String _s,
        String _t,
        boolean _expectedResult) {
        assertEquals(_expectedResult, new Problem0205().isIsomorphic(_s, _t));
    }

}
