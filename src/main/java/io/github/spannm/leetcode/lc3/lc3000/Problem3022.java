package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 3022. Minimize OR of Remaining Elements Using Operations.
 */
class Problem3022 extends LeetcodeProblem {

    int minOrAfterOperations(int[] _nums, int _k) {
        int ans = 0;
        int rans = 0;
        for (int i = 29; i >= 0; i--) {
            int test = ans + (1 << i);
            int cnt = 0;
            int val = 0;
            for (int num : _nums) {
                if (val == 0) {
                    val = test & num;
                } else {
                    val &= test & num;
                }
                if (val != 0) {
                    cnt++;
                }
            }
            if (cnt > _k) {
                rans += 1 << i;
            } else {
                ans += 1 << i;
            }
        }
        return rans;
    }

}
