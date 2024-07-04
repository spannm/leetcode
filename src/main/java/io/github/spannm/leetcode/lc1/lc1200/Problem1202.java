package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1202. Smallest String With Swaps.
 */
class Problem1202 extends LeetcodeProblem {

    private int[] p;

    String smallestStringWithSwaps(String _s, List<List<Integer>> _pairs) {
        int n = _s.length();
        p = new int[n];
        @SuppressWarnings("unchecked")
        List<Character>[] d = new List[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
            d[i] = new ArrayList<>();
        }
        for (var pair : _pairs) {
            int a = pair.get(0);
            int b = pair.get(1);
            p[find(a)] = find(b);
        }
        char[] cs = _s.toCharArray();
        for (int i = 0; i < n; i++) {
            d[find(i)].add(cs[i]);
        }
        for (var e : d) {
            e.sort((a, b) -> b - a);
        }
        for (int i = 0; i < n; i++) {
            var e = d[find(i)];
            cs[i] = e.remove(e.size() - 1);
        }
        return String.valueOf(cs);
    }

    private int find(int _x) {
        if (p[_x] != _x) {
            p[_x] = find(p[_x]);
        }
        return p[_x];
    }

}
