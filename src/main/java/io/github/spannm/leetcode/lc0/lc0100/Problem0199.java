package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Problem0199 extends LeetcodeProblem {

    List<Integer> rightSideView(TreeNode _root) {
        return rightView(_root, new ArrayList<>(), 0);
    }

    static List<Integer> rightView(TreeNode _curr, List<Integer> _result, int _currDepth) {
        if (_curr != null) {
            if (_currDepth == _result.size()) {
                _result.add(_curr.val);
            }
            rightView(_curr.right, _result, _currDepth + 1);
            rightView(_curr.left, _result, _currDepth + 1);
        }
        return _result;
    }

}
