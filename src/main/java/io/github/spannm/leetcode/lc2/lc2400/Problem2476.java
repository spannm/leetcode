package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2476. Closest Nodes Queries in a Binary Search Tree.
 */
class Problem2476 extends LeetcodeProblem {

    private final List<Integer> nums = new ArrayList<>();

    List<List<Integer>> closestNodes(TreeNode _root, List<Integer> _queries) {
        dfs(_root);
        List<List<Integer>> ans = new ArrayList<>();
        for (int x : _queries) {
            int i = Collections.binarySearch(nums, x + 1);
            int j = Collections.binarySearch(nums, x);
            i = i < 0 ? -i - 2 : i - 1;
            j = j < 0 ? -j - 1 : j;
            int mi = i >= 0 && i < nums.size() ? nums.get(i) : -1;
            int mx = j >= 0 && j < nums.size() ? nums.get(j) : -1;
            ans.add(List.of(mi, mx));
        }
        return ans;
    }

    private void dfs(TreeNode _root) {
        if (_root == null) {
            return;
        }
        dfs(_root.left);
        nums.add(_root.val);
        dfs(_root.right);
    }

}
