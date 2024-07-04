package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.HashMap;
import java.util.Map;

class Problem0663 extends LeetcodeProblem {

    boolean checkEqualTree(TreeNode _root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        int totalSum = sumForEachNode(_root, map);
        if (totalSum % 2 != 0 || map.size() < 2) {
            return false;
        }
        for (TreeNode key : map.keySet()) {
            if (map.get(key) == totalSum / 2) {
                return true;
            }
        }
        return false;
    }

    private static int sumForEachNode(TreeNode _root, Map<TreeNode, Integer> _map) {
        if (_root == null) {
            return 0;
        } else if (_root.left == null && _root.right == null) {
            _map.put(_root, _root.val);
            return _root.val;
        }
        int leftVal = 0;
        if (_root.left != null) {
            leftVal = sumForEachNode(_root.left, _map);
        }
        int rightVal = 0;
        if (_root.right != null) {
            rightVal = sumForEachNode(_root.right, _map);
        }
        int val = _root.val + leftVal + rightVal;
        _map.put(_root, val);
        return val;
    }

}
