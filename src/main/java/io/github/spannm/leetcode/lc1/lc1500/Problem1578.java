package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1578. Minimum Time to Make Rope Colorful.
 */
class Problem1578 extends LeetcodeProblem {

    int minCost(String _colors, int[] _neededTime) {
        int ans = 0;
        int n = _neededTime.length;
        for (int i = 0, j = 0; i < n; i = j) {
            j = i;
            int s = 0;
            int max = 0;
            while (j < n && _colors.charAt(j) == _colors.charAt(i)) {
                s += _neededTime[j];
                max = Math.max(max, _neededTime[j]);
                j++;
            }
            if (j - i > 1) {
                ans += s - max;
            }
        }
        return ans;
    }

}
