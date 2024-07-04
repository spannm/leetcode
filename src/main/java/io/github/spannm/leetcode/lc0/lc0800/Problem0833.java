package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 833. Find And Replace in String.
 */
class Problem0833 extends LeetcodeProblem {

    String findReplaceString(String _s, int[] _indices, String[] _sources, String[] _targets) {
        int len = _s.length();
        int[] d = new int[len];
        Arrays.fill(d, -1);
        for (int k = 0; k < _indices.length; k++) {
            int i = _indices[k];
            if (_s.startsWith(_sources[k], i)) {
                d[i] = k;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < len;) {
            if (d[i] >= 0) {
                ans.append(_targets[d[i]]);
                i += _sources[d[i]].length();
            } else {
                ans.append(_s.charAt(i++));
            }
        }
        return ans.toString();
    }

}
