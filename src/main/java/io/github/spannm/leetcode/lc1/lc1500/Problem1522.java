package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1522. Diameter of N-Ary Tree.
 */
class Problem1522 extends LeetcodeProblem {

    static class Solution {
        private int ans;

        public int diameter(Node _root) {
            ans = 0;
            dfs(_root);
            return ans;
        }

        int dfs(Node _root) {
            if (_root == null) {
                return 0;
            }
            int m1 = 0;
            int m2 = 0;
            for (Node child : _root.children) {
                int t = dfs(child);
                if (t > m1) {
                    m2 = m1;
                    m1 = t;
                } else if (t > m2) {
                    m2 = t;
                }
            }
            ans = Math.max(ans, m1 + m2);
            return 1 + m1;
        }
    }

    static class Node {
        private final List<Node> children = new ArrayList<>();
    }

}
