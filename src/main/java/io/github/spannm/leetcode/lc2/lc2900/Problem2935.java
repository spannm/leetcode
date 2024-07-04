package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 2935. Maximum Strong Pair XOR II.
 */
class Problem2935 extends LeetcodeProblem {

    int maximumStrongPairXor(int[] nums) {
        Arrays.sort(nums);
        Trie tree = new Trie();
        int ans = 0;
        int i = 0;
        for (int y : nums) {
            tree.insert(y);
            while (y > nums[i] * 2) {
                tree.remove(nums[i++]);
            }
            ans = Math.max(ans, tree.search(y));
        }
        return ans;
    }

    static class Trie {
        private final Trie[] children = new Trie[2];
        private int          cnt      = 0;

        void insert(int x) {
            Trie node = this;
            for (int i = 20; i >= 0; i--) {
                int v = x >> i & 1;
                if (node.children[v] == null) {
                    node.children[v] = new Trie();
                }
                node = node.children[v];
                node.cnt++;
            }
        }

        int search(int x) {
            Trie node = this;
            int ans = 0;
            for (int i = 20; i >= 0; i--) {
                int v = x >> i & 1;
                if (node.children[v ^ 1] != null && node.children[v ^ 1].cnt > 0) {
                    ans |= 1 << i;
                    node = node.children[v ^ 1];
                } else {
                    node = node.children[v];
                }
            }
            return ans;
        }

        void remove(int x) {
            Trie node = this;
            for (int i = 20; i >= 0; i--) {
                int v = x >> i & 1;
                node = node.children[v];
                node.cnt--;
            }
        }

    }

}
