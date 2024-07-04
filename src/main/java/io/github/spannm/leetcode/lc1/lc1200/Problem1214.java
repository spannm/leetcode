package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Problem1214 extends LeetcodeProblem {

    boolean twoSumBSTs(TreeNode _root1, TreeNode _root2, int _target) {
        if (_root1 == null || _root2 == null) {
            return false;
        }
        List<Integer> inorder1 = inorderDfs(_root1, new ArrayList<>());
        List<Integer> inorder2 = inorderDfs(_root2, new ArrayList<>());
        return findTwoSum(inorder1, inorder2, _target);
    }

    private boolean findTwoSum(List<Integer> _sorted1, List<Integer> _sorted2, int _target) {
        for (Integer element : _sorted1) {
            if (exists(_sorted2, _target - element)) {
                return true;
            }
        }
        return false;
    }

    private boolean exists(List<Integer> _sorted, int _target) {
        int left = 0;
        int right = _sorted.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (_sorted.get(mid) == _target) {
                return true;
            } else if (_sorted.get(mid) < _target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    private List<Integer> inorderDfs(TreeNode _root, List<Integer> _list) {
        if (_root == null) {
            return _list;
        } else if (_root.left != null) {
            _list = inorderDfs(_root.left, _list);
        }
        _list.add(_root.val);
        if (_root.right != null) {
            _list = inorderDfs(_root.right, _list);
        }
        return _list;
    }

}
