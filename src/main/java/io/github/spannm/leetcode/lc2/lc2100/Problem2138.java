package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2138 extends LeetcodeProblem {

    String[] divideString(String _s, int _k, char _fill) {
        int len = _s.length() / _k;
        if (_s.length() % _k != 0) {
            len++;
        }
        String[] ans = new String[len];
        for (int i = 0, j = 0; i < _s.length(); i += _k, j++) {
            if (j == len - 1) {
                StringBuilder sb = new StringBuilder(_s.substring(i));
                if (sb.length() != _k) {
                    while (sb.length() < _k) {
                        sb.append(_fill);
                    }
                }
                ans[j] = sb.toString();
            } else {
                ans[j] = _s.substring(i, i + _k);
            }
        }
        return ans;
    }

}
