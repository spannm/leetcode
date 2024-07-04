package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/optimal-partition-of-string/">2405. Optimal Partition of String</a>.
 */
class Problem2405 extends LeetcodeProblem {

    int partitionString(String _str) {
        int i = 0;
        int ans = 1;
        int flag = 0;
        while (i < _str.length()) {
            int val = _str.charAt(i) - 'a';
            if ((flag & 1 << val) != 0) {
                flag = 0;
                ans++;
            }
            flag = flag | 1 << val;
            i++;
        }
        return ans;
    }

}
