package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 2111. Minimum Operations to Make the Array K-Increasing.
 */
class Problem2111 extends LeetcodeProblem {

    int kIncreasing(int[] arr, int k) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < k; i++) {
            List<Integer> t = new ArrayList<>();
            for (int j = i; j < n; j += k) {
                t.add(arr[j]);
            }
            ans += lis(t);
        }
        return ans;
    }

    private int lis(List<Integer> arr) {
        List<Integer> t = new ArrayList<>();
        for (int x : arr) {
            int idx = searchRight(t, x);
            if (idx == t.size()) {
                t.add(x);
            } else {
                t.set(idx, x);
            }
        }
        return arr.size() - t.size();
    }

    private int searchRight(List<Integer> arr, int x) {
        int left = 0;
        int right = arr.size();
        while (left < right) {
            int mid = left + right >> 1;
            if (arr.get(mid) > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
