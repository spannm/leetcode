package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem0920Test extends LeetcodeBaseTest {

    @ParameterizedTest(name = "[{index}] {0}, {1}, {2} --> {3}")
    @CsvSource(delimiter = ';', value = {
        "3; 3; 1; 6",
        "2; 3; 0; 6",
        "2; 3; 1; 2"
    })
    void test(
        int _songCount,
        int _playlistLen,
        int _repeatAfterCount,
        int _expectedResult) {

        assertEquals(_expectedResult, new Problem0920().numMusicPlaylists(_songCount, _playlistLen, _repeatAfterCount));
    }

}
