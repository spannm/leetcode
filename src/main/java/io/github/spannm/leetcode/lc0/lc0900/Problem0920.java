package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/number-of-music-playlists/">920. Number of Music Playlists</a>.
 */
class Problem0920 extends LeetcodeProblem {

    private static final int MOD = (int) (1e9 + 7);

    int numMusicPlaylists(final int _songCount, final int _playlistLen, final int _repeatAfterCount) {
        int[] used = new int[_songCount + 1];
        Map<String, Integer> memo = new HashMap<>();
        int ways = 0;
        for (int i = 1; i <= _songCount; i++) {
            // start to try every number
            ways = (ways + calc(_songCount, _playlistLen, _repeatAfterCount, used, 1, i, 1, memo)) % MOD;
        }

        used = null;
        memo = null;
        System.gc();

        return ways;
    }

    private static int calc(int _songCount, int _playlistLen, int _repeatAfterCount, int[] _used, int _count, int _current, int _distinct, Map<String, Integer> _memo) {

        if (_used[_current] > 0 && _count - _used[_current] <= _repeatAfterCount) {
            // if current num exist in last k numbers
            return 0;
        } else if (_playlistLen == _count) {
            // if used numbers count(distinct) == goal
            return _distinct == _songCount ? 1 : 0;
        }
        String key = _count + "_" + _distinct; // state
        Integer v = _memo.get(key);
        if (v != null) {
            return v;
        }

        int tmp = _used[_current];
        _used[_current] = _count;
        int ways = 0;
        for (int i = 1; i <= _songCount; i++) {
            // if this number i is not used before then distinct += 1
            ways = (ways + calc(_songCount, _playlistLen, _repeatAfterCount, _used, _count + 1, i, _used[i] == 0 ? _distinct + 1 : _distinct, _memo)) % MOD;
        }
        _used[_current] = tmp; // backtrack
        _memo.put(key, ways); // cache
        return ways;

    }

}
