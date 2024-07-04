package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2383. Minimum Hours of Training to Win a Competition.
 */
class Problem2383 extends LeetcodeProblem {

    int minNumberOfHours(
        int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ans = 0;
        for (int i = 0; i < energy.length; i++) {
            int a = energy[i];
            int b = experience[i];
            if (initialEnergy <= a) {
                ans += a - initialEnergy + 1;
                initialEnergy = a + 1;
            }
            if (initialExperience <= b) {
                ans += b - initialExperience + 1;
                initialExperience = b + 1;
            }
            initialEnergy -= a;
            initialExperience += b;
        }
        return ans;
    }

}
