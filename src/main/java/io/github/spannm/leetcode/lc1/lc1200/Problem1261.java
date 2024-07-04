package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem1261 extends LeetcodeProblem {
    static class FindElements {

        private final TreeNode recoveredRoot;

        FindElements(TreeNode _root) {
            recoveredRoot = recoverTree(_root, new TreeNode(0));
        }

        private TreeNode recoverTree(TreeNode _root, TreeNode _recoveredRoot) {
            if (_root == null) {
                return _recoveredRoot;
            } else if (_root.left != null) {
                _recoveredRoot.left = new TreeNode(_recoveredRoot.val * 2 + 1);
            }
            if (_root.right != null) {
                _recoveredRoot.right = new TreeNode(_recoveredRoot.val * 2 + 2);
            }
            recoverTree(_root.left, _recoveredRoot.left);
            recoverTree(_root.right, _recoveredRoot.right);
            return _recoveredRoot;
        }

        public boolean find(int _target) {
            return find(recoveredRoot, _target);
        }

        private boolean find(TreeNode _root, int _target) {
            if (_root == null) {
                return false;
            } else if (_root.val == _target) {
                return true;
            }
            return find(_root.left, _target) || find(_root.right, _target);
        }
    }

}
