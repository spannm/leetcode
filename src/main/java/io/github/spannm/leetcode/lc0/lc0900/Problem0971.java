package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 971. Flip Binary Tree To Match Preorder Traversal.
 */
class Problem0971 extends LeetcodeProblem {

    private int                 i;
    private boolean             ok;
    private int[]               voyage;
    private final List<Integer> ans = new ArrayList<>();

    List<Integer> flipMatchVoyage(TreeNode _root, int[] _voyage) {
        voyage = _voyage;
        ok = true;
        dfs(_root);
        return ok ? ans : List.of(-1);
    }

    private void dfs(TreeNode _root) {
        if (_root == null || !ok) {
            return;
        } else if (_root.val != voyage[i]) {
            ok = false;
            return;
        }
        i++;
        if (_root.left == null || _root.left.val == voyage[i]) {
            dfs(_root.left);
            dfs(_root.right);
        } else {
            ans.add(_root.val);
            dfs(_root.right);
            dfs(_root.left);
        }
    }

}
