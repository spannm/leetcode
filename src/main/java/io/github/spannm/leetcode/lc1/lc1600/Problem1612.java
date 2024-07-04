package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 1612. Check If Two Expression Trees are Equivalent.
 */
class Problem1612 extends LeetcodeProblem {

    boolean checkEquivalence(Node _root1, Node _root2) {
        int[] cnt1 = dfs(_root1);
        int[] cnt2 = dfs(_root2);
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) {
                return false;
            }
        }
        return true;
    }

    static int[] dfs(Node _root) {
        int[] cnt = new int[26];
        if (_root == null) {
            return cnt;
        }
        if (_root.val == '+' || _root.val == '-') {
            int[] l = dfs(_root.left);
            int[] r = dfs(_root.right);
            int k = _root.val == '+' ? 1 : -1;
            for (int i = 0; i < 26; i++) {
                cnt[i] += l[i] + r[i] * k;
            }
        } else {
            cnt[_root.val - 'a']++;
        }
        return cnt;
    }

    static class Node {
        private final char val;
        private Node       left;
        private Node       right;

        Node() {
            val = ' ';
        }

        Node(char _val) {
            val = _val;
        }

        Node(char _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

}
