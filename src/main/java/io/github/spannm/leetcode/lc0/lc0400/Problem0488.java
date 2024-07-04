package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0488 extends LeetcodeProblem {

    private static final int MAX_COUNT = 6;

    int findMinStep(String _board, String _hand) {
        int[] handCount = new int[26];
        for (int i = 0; i < _hand.length(); i++) {
            handCount[_hand.charAt(i) - 'A']++;
        }
        int result = dfs(_board + "#", handCount);
        return result == MAX_COUNT ? -1 : result;
    }

    static int dfs(String _s, int[] _handCount) {
        _s = removeConsecutive(_s);
        if ("#".equals(_s)) {
            return 0;
        }
        int result = MAX_COUNT;
        int need = 0;
        for (int i = 0, j = 0; j < _s.length(); j++) {
            if (_s.charAt(j) == _s.charAt(i)) {
                continue;
            }
            need = 3 - (j - i);
            if (_handCount[_s.charAt(i) - 'A'] >= need) {
                _handCount[_s.charAt(i) - 'A'] -= need;
                result = Math.min(result, need + dfs(_s.substring(0, i) + _s.substring(j), _handCount));
                _handCount[_s.charAt(i) - 'A'] += need;
            }
            i = j;
        }
        return result;
    }

    static String removeConsecutive(String _board) {
        for (int i = 0, j = 0; j < _board.length(); j++) {
            if (_board.charAt(j) == _board.charAt(i)) {
                continue;
            }
            if (j - i >= 3) {
                return removeConsecutive(_board.substring(0, i) + _board.substring(j));
            } else {
                i = j;
            }
        }
        return _board;
    }

}
