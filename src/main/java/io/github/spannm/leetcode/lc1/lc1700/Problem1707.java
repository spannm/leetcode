package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1707. Maximum XOR With an Element From Array.
 */
class Problem1707 extends LeetcodeProblem {

    int[] maximizeXor(int[] nums, int[][] queries) {
        Trie trie = new Trie();
        Arrays.sort(nums);
        int n = queries.length;
        int[] ans = new int[n];
        int[][] qs = new int[n][3];
        for (int i = 0; i < n; i++) {
            qs[i] = new int[] {i, queries[i][0], queries[i][1]};
        }
        Arrays.sort(qs, Comparator.comparingInt(a -> a[2]));
        int j = 0;
        for (var q : qs) {
            int i = q[0];
            int x = q[1];
            int m = q[2];
            while (j < nums.length && nums[j] <= m) {
                trie.insert(nums[j++]);
            }
            ans[i] = trie.search(x);
        }
        return ans;
    }

    static class Trie {
        private final Trie[] children = new Trie[2];

        void insert(int _x) {
            Trie node = this;
            for (int i = 30; i >= 0; i--) {
                int v = _x >> i & 1;
                if (node.children[v] == null) {
                    node.children[v] = new Trie();
                }
                node = node.children[v];
            }
        }

        int search(int _x) {
            Trie node = this;
            int ans = 0;
            for (int i = 30; i >= 0; i--) {
                int v = _x >> i & 1;
                if (node.children[v ^ 1] != null) {
                    ans |= 1 << i;
                    node = node.children[v ^ 1];
                } else if (node.children[v] != null) {
                    node = node.children[v];
                } else {
                    return -1;
                }
            }
            return ans;
        }

    }

}
