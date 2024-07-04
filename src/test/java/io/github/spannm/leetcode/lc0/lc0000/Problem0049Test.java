package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Problem0049Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "eat,tea,tan,ate,nat,bat; [bat],[nat,tan],[ate,eat,tea]",
        "''; ",
        "a; [a]",
        "hhhhu,tttti,tttit,hhhuh,hhuhh,tittt; [tttti,tttit,tittt],[hhhhu,hhhuh,hhuhh]"
    })
    void test(
        @ConvertWith(CsvToStringArray.class) String[] _input,
        @ConvertWith(CsvToListOfStringLists.class) List<List<String>> _expected) {

        List<List<String>> actual = new Problem0049().groupAnagrams(_input);

        assertEquals(_expected.size(), actual.size());

        List<List<String>> sortedExpected = _expected.stream().map(Problem0049Test::sort).sorted(Comparator.comparing(Object::toString)).toList();
        List<List<String>> sortedActual = actual.stream().map(Problem0049Test::sort).sorted(Comparator.comparing(Object::toString)).toList();

        assertEquals(sortedExpected, sortedActual);
    }

    static List<String> sort(List<String> _c) {
        _c = new ArrayList<>(_c);
        Collections.sort(_c);
        return _c;
    }
}
