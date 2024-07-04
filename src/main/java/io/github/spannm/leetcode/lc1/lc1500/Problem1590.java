package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 1590. Make Sum Divisible by P.
 */
class Problem1590 extends LeetcodeProblem {

    int minSubarray(int[] nums, int p) {
        int k = 0;
        for (int x : nums) {
            k = (k + x) % p;
        }
        if (k == 0) {
            return 0;
        }
        Map<Integer, Integer> last = new HashMap<>();
        last.put(0, -1);
        int n = nums.length;
        int ans = n;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur = (cur + nums[i]) % p;
            int target = (cur - k + p) % p;
            if (last.containsKey(target)) {
                ans = Math.min(ans, i - last.get(target));
            }
            last.put(cur, i);
        }
        return ans == n ? -1 : ans;
    }

}
