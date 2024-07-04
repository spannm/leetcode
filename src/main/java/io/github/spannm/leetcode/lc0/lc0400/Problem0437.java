package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. Path Sum III.
 */
class Problem0437 extends LeetcodeProblem {

    int pathSum(TreeNode _root, int _targetSum) {
        Map<Long, Integer> cnt = new HashMap<>();
        cnt.put(0L, 1);
        return dfs(_root, 0, _targetSum, cnt);
    }

    static int dfs(TreeNode node, long s, int _targetSum, Map<Long, Integer> _cnt) {
        if (node == null) {
            return 0;
        }
        s += node.val;
        int ans = _cnt.getOrDefault(s - _targetSum, 0);
        _cnt.merge(s, 1, Integer::sum);
        ans += dfs(node.left, s, _targetSum, _cnt);
        ans += dfs(node.right, s, _targetSum, _cnt);
        _cnt.merge(s, -1, Integer::sum);
        return ans;
    }

}
