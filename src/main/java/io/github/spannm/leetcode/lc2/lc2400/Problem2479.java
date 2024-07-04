package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2479. Maximum XOR of Two Non-Overlapping Subtrees.
 */
class Problem2479 extends LeetcodeProblem {

    private List<Integer>[] g;
    private int[]           vals;
    private long[]          s;
    private Trie            tree;
    private long            ans;

    long maxXor(int _n, int[][] _edges, int[] _values) {
        @SuppressWarnings("unchecked")
        List<Integer>[] lists = new List[_n];
        g = lists;
        s = new long[_n];
        vals = _values;
        Arrays.setAll(g, k -> new ArrayList<>());
        for (var e : _edges) {
            int a = e[0];
            int b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        dfs1(0, -1);
        tree = new Trie();
        dfs2(0, -1);
        return ans;
    }

    void dfs2(int i, int fa) {
        ans = Math.max(ans, tree.search(s[i]));
        for (int j : g[i]) {
            if (j != fa) {
                dfs2(j, i);
            }
        }
        tree.insert(s[i]);
    }

    long dfs1(int i, int fa) {
        long t = vals[i];
        for (int j : g[i]) {
            if (j != fa) {
                t += dfs1(j, i);
            }
        }
        s[i] = t;
        return t;
    }

    static class Trie {
        private final Trie[] children = new Trie[2];

        void insert(long x) {
            Trie node = this;
            for (int i = 47; i >= 0; i--) {
                int v = (int) (x >> i) & 1;
                if (node.children[v] == null) {
                    node.children[v] = new Trie();
                }
                node = node.children[v];
            }
        }

        long search(long x) {
            Trie node = this;
            long res = 0;
            for (int i = 47; i >= 0; i--) {
                int v = (int) (x >> i) & 1;
                if (node == null) {
                    return res;
                }
                if (node.children[v ^ 1] != null) {
                    res = res << 1 | 1;
                    node = node.children[v ^ 1];
                } else {
                    res <<= 1;
                    node = node.children[v];
                }
            }
            return res;
        }

    }

}
