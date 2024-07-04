package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.TreeSet;

class Problem1439 extends LeetcodeProblem {

    int kthSmallest(int[][] _mat, int _k) {
        TreeSet<int[]> treeSet = new TreeSet<>((o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                for (int i = 1; i < o1.length; i++) {
                    if (o1[i] != o2[i]) {
                        return o1[i] - o2[i];
                    }
                }
                return 0;
            }
        });
        int m = _mat.length;
        int n = _mat[0].length;
        int sum = 0;
        int[] entry = new int[m + 1];
        for (int[] ints : _mat) {
            sum += ints[0];
        }
        entry[0] = sum;
        treeSet.add(entry);
        int count = 0;
        while (count < _k) {
            int[] curr = treeSet.pollFirst();
            count++;
            if (count == _k) {
                return curr[0];
            }
            for (int i = 0; i < m; i++) {
                int[] next = Arrays.copyOf(curr, curr.length);
                if (curr[i + 1] + 1 < n) {
                    next[0] -= _mat[i][curr[i + 1]];
                    next[0] += _mat[i][curr[i + 1] + 1];
                    next[i + 1]++;
                    treeSet.add(next);
                }
            }
        }
        return -1;
    }

}
