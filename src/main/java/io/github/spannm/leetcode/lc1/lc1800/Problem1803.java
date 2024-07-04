package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1803. Count Pairs With XOR in a Range.
 */
class Problem1803 extends LeetcodeProblem {

    int countPairs(int[] _nums, int _low, int _high) {
        Trie trie = new Trie();
        int ans = 0;
        for (int x : _nums) {
            ans += trie.search(x, _high + 1) - trie.search(x, _low);
            trie.insert(x);
        }
        return ans;
    }

    static class Trie {
        private final Trie[] children = new Trie[2];
        private int          cnt;

        void insert(int _x) {
            Trie node = this;
            for (int i = 15; i >= 0; i--) {
                int v = _x >> i & 1;
                if (node.children[v] == null) {
                    node.children[v] = new Trie();
                }
                node = node.children[v];
                node.cnt++;
            }
        }

        int search(int x, int limit) {
            Trie node = this;
            int ans = 0;
            for (int i = 15; i >= 0 && node != null; i--) {
                int v = x >> i & 1;
                if ((limit >> i & 1) == 1) {
                    if (node.children[v] != null) {
                        ans += node.children[v].cnt;
                    }
                    node = node.children[v ^ 1];
                } else {
                    node = node.children[v];
                }
            }
            return ans;
        }

    }
}
