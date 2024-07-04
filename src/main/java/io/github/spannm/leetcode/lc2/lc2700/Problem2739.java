package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2739. Total Distance Traveled.
 */
class Problem2739 extends LeetcodeProblem {

    int distanceTraveled(int mainTank, int additionalTank) {
        int ans = 0;
        int cur = 0;
        while (mainTank > 0) {
            cur++;
            ans += 10;
            mainTank--;
            if (cur % 5 == 0 && additionalTank > 0) {
                additionalTank--;
                mainTank++;
            }
        }
        return ans;
    }

}
