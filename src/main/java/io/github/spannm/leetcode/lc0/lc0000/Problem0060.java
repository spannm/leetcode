package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/permutation-sequence/">60. Permutation Sequence</a>.
 */
class Problem0060 extends LeetcodeProblem {

    String getPermutation(int _n, int _k) {
        int[] nums = new int[_n + 1];
        int permCount = 1;
        for (int i = 0; i < _n; i++) {
            nums[i] = i + 1; // put 1, 2, 3 ... n into nums[]
            permCount *= i + 1;
        }

        _k--;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < _n; i++) {
            permCount = permCount / (_n - i);
            int idx = _k / permCount; // the index that this position should
            // choose
            sb.append(nums[idx]);
            // left shift nums[] by one bit
            if (_n - i - idx >= 0) {
                System.arraycopy(nums, idx + 1, nums, idx, _n - i - idx);
            }
            _k %= permCount;
        }
        return sb.toString();
    }

}
