package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0278Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0} --> {1}")
    @CsvSource(delimiter = ';', value = {
        "5; 4",
        "1; 1",
        "100; 50"
    })
    void test(
        final int _version,
        final int _badVersion) {
        assertEquals(_badVersion, new Problem0278() {
            @Override
            public boolean isBadVersionImpl(int _version) {
                return _version >= _badVersion;
            }
        }.firstBadVersion(_version));
    }

}
