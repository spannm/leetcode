package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2902. Count of Sub-Multisets With Bounded Sum.
 */
class Problem2902 extends LeetcodeProblem {

    static final int MOD = 1_000_000_007;

    int countSubMultisets(List<Integer> nums, int l, int r) {
        Map<Integer, Integer> count = new HashMap<>();
        int total = 0;
        for (int num : nums) {
            total += num;
            if (num <= r) {
                count.merge(num, 1, Integer::sum);
            }
        }
        if (total < l) {
            return 0;
        }
        r = Math.min(r, total);
        int[] dp = new int[r + 1];
        dp[0] = count.getOrDefault(0, 0) + 1;
        count.remove(0);
        int sum = 0;
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            int num = e.getKey();
            int c = e.getValue();
            sum = Math.min(sum + c * num, r);

            for (int i = num; i <= sum; i++) {
                dp[i] = (dp[i] + dp[i - num]) % MOD;
            }
            int temp = (c + 1) * num;

            // leves dp[i] = dp[i] + dp[i-num] +...+ dp[i - c*num];
            for (int i = sum; i >= temp; i--) {
                dp[i] = (dp[i] - dp[i - temp] + MOD) % MOD;
            }
        }
        int ans = 0;
        for (int i = l; i <= r; i++) {
            ans += dp[i];
            ans %= MOD;
        }
        return ans;
    }

}
