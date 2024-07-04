package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0606 extends LeetcodeProblem {

    String tree2str(TreeNode _t) {
        if (_t == null) {
            return "";
        }
        String res = "" + _t.val;
        String l = tree2str(_t.left);
        String r = tree2str(_t.right);
        if (l.isEmpty() && r.isEmpty()) {
            return res;
        } else if (l.isEmpty()) {
            return res + "()(" + r + ")";
        } else if (r.isEmpty()) {
            return res + "(" + l + ")";
        }
        return res + "(" + l + ")(" + r + ")";
    }

}
