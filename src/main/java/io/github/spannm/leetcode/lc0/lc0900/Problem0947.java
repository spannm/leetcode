package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 947. Most Stones Removed with Same Row or Column.
 */
class Problem0947 extends LeetcodeProblem {

    private int[] p;

    int removeStones(int[][] _stones) {
        int n = 10010;
        p = new int[n << 1];
        for (int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        for (int[] stone : _stones) {
            p[find(stone[0])] = find(stone[1] + n);
        }
        Set<Integer> s = new HashSet<>();
        for (int[] stone : _stones) {
            s.add(find(stone[0]));
        }
        return _stones.length - s.size();
    }

    private int find(int _x) {
        if (p[_x] != _x) {
            p[_x] = find(p[_x]);
        }
        return p[_x];
    }

}
