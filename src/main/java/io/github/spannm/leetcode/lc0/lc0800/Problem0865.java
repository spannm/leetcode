package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

/**
 * 865. Smallest Subtree with all the Deepest Nodes.
 */
class Problem0865 extends LeetcodeProblem {

    TreeNode subtreeWithAllDeepest(TreeNode _root) {
        return dfs(_root).getKey();
    }

    private Pair<TreeNode, Integer> dfs(TreeNode _root) {
        if (_root == null) {
            return new Pair<>(null, 0);
        }
        Pair<TreeNode, Integer> l = dfs(_root.left);
        Pair<TreeNode, Integer> r = dfs(_root.right);
        int d1 = l.getValue();
        int d2 = r.getValue();
        if (d1 > d2) {
            return new Pair<>(l.getKey(), d1 + 1);
        }
        if (d1 < d2) {
            return new Pair<>(r.getKey(), d2 + 1);
        }
        return new Pair<>(_root, d1 + 1);
    }

    static class Pair<K, V> {
        private final K key;
        private final V val;

        Pair(K _key, V _val) {
            key = _key;
            val = _val;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return val;
        }
    }

}
