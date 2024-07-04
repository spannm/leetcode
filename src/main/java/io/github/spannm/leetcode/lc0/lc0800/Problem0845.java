package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 845. Longest Mountain in Array.
 */
class Problem0845 extends LeetcodeProblem {

    int longestMountain(int[] _arr) {
        int len = _arr.length;
        int ans = 0;
        for (int l = 0, r = 0; l + 2 < len; l = r) {
            r = l + 1;
            if (_arr[l] < _arr[r]) {
                while (r + 1 < len && _arr[r] < _arr[r + 1]) {
                    r++;
                }
                if (r + 1 < len && _arr[r] > _arr[r + 1]) {
                    while (r + 1 < len && _arr[r] > _arr[r + 1]) {
                        r++;
                    }
                    ans = Math.max(ans, r - l + 1);
                } else {
                    r++;
                }
            }
        }
        return ans;
    }

}
