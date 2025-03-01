package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2231. Largest Number After Digit Swaps by Parity.
 */
class Problem2231 extends LeetcodeProblem {

    int largestInteger(int num) {
        int[] cnt = new int[10];
        int x = num;
        while (x != 0) {
            cnt[x % 10]++;
            x /= 10;
        }
        x = num;
        int ans = 0;
        int t = 1;
        while (x != 0) {
            int v = x % 10;
            x /= 10;
            for (int y = 0; y < 10; y++) {
                if (((v ^ y) & 1) == 0 && cnt[y] > 0) {
                    cnt[y]--;
                    ans += y * t;
                    t *= 10;
                    break;
                }
            }
        }
        return ans;
    }

}
