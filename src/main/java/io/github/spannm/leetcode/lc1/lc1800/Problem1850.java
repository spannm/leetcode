package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1850. Minimum Adjacent Swaps to Reach the Kth Smallest Number.
 */
class Problem1850 extends LeetcodeProblem {

    int getMinSwaps(String _num, int _k) {
        char[] chars = _num.toCharArray();
        for (int i = 0; i < _k; i++) {
            nextPermutation(chars);
        }
        @SuppressWarnings("unchecked")
        List<Integer>[] d = new List[10];
        Arrays.setAll(d, i -> new ArrayList<>());
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            d[_num.charAt(i) - '0'].add(i);
        }
        int[] idx = new int[10];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = d[chars[i] - '0'].get(idx[chars[i] - '0']++);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    ++ans;
                }
            }
        }
        return ans;
    }

    static boolean nextPermutation(char[] nums) {
        int n = nums.length;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        int j = n - 1;
        while (j >= 0 && nums[i] >= nums[j]) {
            j--;
        }
        swap(nums, i++, j);
        for (j = n - 1; i < j; i++, j--) {
            swap(nums, i, j);
        }
        return true;
    }

    static void swap(char[] _nums, int _i, int _j) {
        char t = _nums[_i];
        _nums[_i] = _nums[_j];
        _nums[_j] = t;
    }

}
