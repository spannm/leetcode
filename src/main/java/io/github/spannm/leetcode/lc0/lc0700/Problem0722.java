package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 722. Remove Comments.
 */
class Problem0722 extends LeetcodeProblem {

    List<String> removeComments(String[] _source) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean blockComment = false;
        for (String s : _source) {
            int m = s.length();
            for (int i = 0; i < m; i++) {
                if (blockComment) {
                    if (i + 1 < m && s.charAt(i) == '*' && s.charAt(i + 1) == '/') {
                        blockComment = false;
                        i++;
                    }
                } else {
                    if (i + 1 < m && s.charAt(i) == '/' && s.charAt(i + 1) == '*') {
                        blockComment = true;
                        i++;
                    } else if (i + 1 < m && s.charAt(i) == '/' && s.charAt(i + 1) == '/') {
                        break;
                    } else {
                        sb.append(s.charAt(i));
                    }
                }
            }
            if (!blockComment && !sb.isEmpty()) {
                ans.add(sb.toString());
                sb.setLength(0);
            }
        }
        return ans;
    }

}
