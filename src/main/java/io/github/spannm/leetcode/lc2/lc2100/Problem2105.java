package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2105. Watering Plants II.
 */
class Problem2105 extends LeetcodeProblem {

    int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int i = 0;
        int j = plants.length - 1;
        int ans = 0;
        int a = capacityA;
        int b = capacityB;
        while (i <= j) {
            if (i == j) {
                if (Math.max(capacityA, capacityB) < plants[i]) {
                    ans++;
                }
                break;
            }
            if (capacityA < plants[i]) {
                capacityA = a - plants[i];
                ans++;
            } else {
                capacityA -= plants[i];
            }
            if (capacityB < plants[j]) {
                capacityB = b - plants[j];
                ans++;
            } else {
                capacityB -= plants[j];
            }
            i++;
            j--;
        }
        return ans;
    }

}
