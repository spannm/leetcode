package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 508. Most Frequent Subtree Sum.
 */
class Problem0508 extends LeetcodeProblem {

    private Map<Integer, Integer> counter;
    private int                   max;

    int[] findFrequentTreeSum(TreeNode _root) {
        counter = new HashMap<>();
        max = Integer.MIN_VALUE;
        dfs(_root);
        return counter.entrySet().stream().filter(e -> e.getValue() == max).map(Map.Entry::getKey)
            .mapToInt(i -> i).toArray();
    }

    private int dfs(TreeNode _node) {
        if (_node == null) {
            return 0;
        }
        int s = _node.val + dfs(_node.left) + dfs(_node.right);
        counter.compute(s, (k, v) -> (v == null) ? 1 : v + 1);
        max = Math.max(max, counter.get(s));
        return s;
    }

}
