package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/maximize-score-after-n-operations/">1799. Maximize Score After N
 * Operations</a>
 * <p>
 * Solution: <a href=
 * "">https://leetcode.com/problems/maximize-score-after-n-operations/solutions/3521564/easy-c-java-code-step-by-step-explanation/</a>
 */
class Problem1799 extends LeetcodeProblem {

    int maxScore(int[] _nums) {
        final int len = _nums.length;
        final int[] dp = new int[1 << len];
        List<Integer> nums = new ArrayList<>(len);
        for (int num : _nums) {
            nums.add(num);
        }
        return dfs(nums, (1 << len) - 1, len / 2, dp);
    }

    static int dfs(List<Integer> _nums, int _state, int _current, int[] _dp) {
        if (_current == 0) {
            return 0;
        } else if (_dp[_state] != 0) {
            return _dp[_state];
        }
        int res = 0;
        int n = _nums.size();

        List<Integer> total = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if ((_state & 1 << i) != 0) {
                total.add(i);
            }
        }

        int totalSize = total.size();
        for (int ia = 0; ia < totalSize; ia++) {
            for (int ib = ia + 1; ib < totalSize; ib++) {
                res = Math.max(res, gcd(_nums.get(total.get(ia)), _nums.get(total.get(ib))) * _current
                    + dfs(_nums, _state & ~(1 << total.get(ia)) & ~(1 << total.get(ib)), _current - 1, _dp));
            }
        }

        _dp[_state] = res;
        return res;
    }

    /**
     * Euclidean algorithm, or Euclid's algorithm, is an efficient method for computing the greatest common divisor
     * (GCD) of two integers (numbers), the largest number that divides them both without a remainder.
     */
    static int gcd(int _a, int _b) {
        if (_b == 0) {
            return _a;
        }
        return gcd(_b, _a % _b);
    }

}
