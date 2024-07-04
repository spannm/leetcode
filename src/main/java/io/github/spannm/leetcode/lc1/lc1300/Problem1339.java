package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.HashSet;
import java.util.Set;

class Problem1339 extends LeetcodeProblem {

    int maxProduct(TreeNode _root) {
        Set<Long> set = new HashSet<>();
        int total = dfs(_root, set);
        long result = 0L;
        for (long sum : set) {
            result = Math.max(result, sum * (total - sum));
        }
        return (int) (result % 1000000007);
    }

    private int dfs(TreeNode _root, Set<Long> _set) {
        if (_root == null) {
            return 0;
        }
        _root.val += dfs(_root.left, _set);
        _root.val += dfs(_root.right, _set);
        _set.add((long) _root.val);
        return _root.val;
    }

}
