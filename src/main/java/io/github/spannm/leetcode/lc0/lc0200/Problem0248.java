package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0248 extends LeetcodeProblem {

    private static final char[][] PAIRS = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

    int strobogrammaticInRange(String _low, String _high) {
        int[] count = {0};
        for (int len = _low.length(); len <= _high.length(); len++) {
            char[] c = new char[len];
            dfs(_low, _high, c, 0, len - 1, count);
        }
        return count[0];
    }

    static void dfs(String _low, String _high, char[] _c, int _left, int _right, int[] _count) {
        if (_left > _right) {
            String s = new String(_c);
            if (s.length() == _low.length() && s.compareTo(_low) < 0
                || s.length() == _high.length() && s.compareTo(_high) > 0) {
                return;
            }
            _count[0]++;
            return;
        }
        for (char[] p : PAIRS) {
            _c[_left] = p[0];
            _c[_right] = p[1];
            if (_c.length != 1 && _c[0] == '0' || _left == _right && p[0] != p[1]) {
                continue;
            }
            dfs(_low, _high, _c, _left + 1, _right - 1, _count);
        }
    }

}
