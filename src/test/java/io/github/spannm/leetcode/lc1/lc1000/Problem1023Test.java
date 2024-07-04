package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Problem1023Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] [{0}] pattern {1} --> {2}")
    @CsvSource(delimiter = ';', value = {
        "FooBar,FooBarTest,FootBall,FrameBuffer,ForceFeedBack; FB; true,false,true,true,false",
        "FooBar,FooBarTest,FootBall,FrameBuffer,ForceFeedBack; FoBa; true,false,true,false,false",
        "FooBar,FooBarTest,FootBall,FrameBuffer,ForceFeedBack; FoBaT; false,true,false,false,false"
    })

    void test(
        @ConvertWith(CsvToStringArray.class) String[] _queries,
        String _pattern,
        @ConvertWith(CsvToBooleanList.class) List<Boolean> _expectedResult) {

        List<Boolean> results = new Problem1023().camelMatch(_queries, _pattern);
        for (int i = 0; i < _queries.length; i++) {
            assertEquals(_expectedResult.get(i), results.get(i), "Mismatch: " + _queries[i]);
        }
    }

}
