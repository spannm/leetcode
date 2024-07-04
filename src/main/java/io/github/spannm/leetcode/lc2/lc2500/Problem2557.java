package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 2557. Maximum Number of Integers to Choose From a Range II.
 */
class Problem2557 extends LeetcodeProblem {

    int maxCount(int[] banned, int n, long maxSum) {
        Set<Integer> black = new HashSet<>();
        black.add(0);
        black.add(n + 1);
        for (int x : banned) {
            black.add(x);
        }
        List<Integer> ban = new ArrayList<>(black);
        Collections.sort(ban);
        int ans = 0;
        for (int k = 1; k < ban.size(); k++) {
            int i = ban.get(k - 1);
            int j = ban.get(k);
            int left = 0;
            int right = j - i - 1;
            while (left < right) {
                int mid = left + right + 1 >>> 1;
                if ((i + 1 + i + mid) * 1L * mid / 2 <= maxSum) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            ans += left;
            maxSum -= (i + 1 + i + left) * 1L * left / 2;
            if (maxSum <= 0) {
                break;
            }
        }
        return ans;
    }

}
