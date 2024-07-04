package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;

class Problem2099 extends LeetcodeProblem {

    int[] maxSubsequence(int[] _nums, int _k) {
        int[][] map = new int[_nums.length][2];
        for (int i = 0; i < _nums.length; i++) {
            map[i][0] = _nums[i];
            map[i][1] = i;
        }
        Arrays.sort(map, (a, b) -> b[0] - a[0]);
        int[][] arr = new int[_k][2];
        for (int i = 0; i < _k; i++) {
            arr[i][0] = map[i][0];
            arr[i][1] = map[i][1];
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));
        int[] ans = new int[_k];
        for (int i = 0; i < _k; i++) {
            ans[i] = arr[i][0];
        }
        return ans;
    }

}
