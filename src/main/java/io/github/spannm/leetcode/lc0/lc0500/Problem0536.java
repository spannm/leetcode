package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

class Problem0536 extends LeetcodeProblem {

    TreeNode str2tree(String _s) {
        if (_s.isEmpty()) {
            return null;
        }
        int firstParen = _s.indexOf('(');
        int val = firstParen == -1 ? Integer.parseInt(_s) : Integer.parseInt(_s.substring(0, firstParen));
        TreeNode cur = new TreeNode(val);
        if (firstParen == -1) {
            return cur;
        }
        int start = firstParen;
        int leftParenCount = 0;
        for (int i = start; i < _s.length(); i++) {
            if (_s.charAt(i) == '(') {
                leftParenCount++;
            } else if (_s.charAt(i) == ')') {
                leftParenCount--;
            }
            if (leftParenCount == 0 && start == firstParen) {
                cur.left = str2tree(_s.substring(start + 1, i));
                start = i + 1;
            } else if (leftParenCount == 0) {
                cur.right = str2tree(_s.substring(start + 1, i));
            }
        }
        return cur;
    }

}
