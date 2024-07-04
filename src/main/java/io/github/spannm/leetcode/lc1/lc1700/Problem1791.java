package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1791 extends LeetcodeProblem {

    int findCenter(int[][] _edges) {
        int count = _edges.length;
        int[] neighbors = new int[count + 1];
        for (int[] edge : _edges) {
            int a = edge[0];
            int b = edge[1];
            neighbors[a - 1]++;
            neighbors[b - 1]++;
        }
        for (int i = 0; i < neighbors.length; i++) {
            if (neighbors[i] == count) {
                return i + 1;
            }
        }
        return -1;
    }

}
