package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 1521. Find a Value of a Mysterious Function Closest to Target.
 */
class Problem1521 extends LeetcodeProblem {

    int closestToTarget(int[] arr, int target) {
        int ans = Math.abs(arr[0] - target);
        Set<Integer> pre = new HashSet<>();
        pre.add(arr[0]);
        for (int x : arr) {
            Set<Integer> cur = new HashSet<>();
            for (int y : pre) {
                cur.add(x & y);
            }
            cur.add(x);
            for (int y : cur) {
                ans = Math.min(ans, Math.abs(y - target));
            }
            pre = cur;
        }
        return ans;
    }

}
