package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem1125Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "java,nodejs,reactjs; [java],[nodejs],[nodejs,reactjs]; 0,2",
        "algorithms,math,java,reactjs,csharp,aws; [algorithms,math,java],[algorithms,math,reactjs],[java,csharp,aws],[reactjs,csharp],[csharp,math],[aws,java]; 1,2"
    })
    void test(
        @ConvertWith(CsvToStringArray.class) String[] _requiredSkills,
        @ConvertWith(CsvToListOfStringLists.class) List<List<String>> _people,
        @ConvertWith(CsvToIntArray.class) int[] _expectedResult) {

        assertArrayEquals(_expectedResult, new Problem1125().smallestSufficientTeam(_requiredSkills, _people));
    }

}
