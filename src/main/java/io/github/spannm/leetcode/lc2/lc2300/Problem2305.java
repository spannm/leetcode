package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/fair-distribution-of-cookies/">2305. Fair Distribution of Cookies</a>.
 */
class Problem2305 extends LeetcodeProblem {

    int distributeCookies(final int[] _cookies, final int _nbChildren) {
        final int[] children = new int[_nbChildren];
        return backTrack(_cookies, 0, children);
    }

    static int backTrack(final int[] _cookies, final int _bag, final int[] _children) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < _children.length; i++) {
            _children[i] += _cookies[_bag];

            int newVal = 0;
            if (_bag == _cookies.length - 1) {
                for (var a : _children) {
                    newVal = Math.max(newVal, a);
                }
            } else {
                newVal = backTrack(_cookies, _bag + 1, _children);
            }
            ans = Math.min(ans, newVal);
            _children[i] -= _cookies[_bag];
        }
        return ans;
    }

}
