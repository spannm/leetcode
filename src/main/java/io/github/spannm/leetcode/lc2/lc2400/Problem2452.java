package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 2452. Words Within Two Edits of Dictionary.
 */
class Problem2452 extends LeetcodeProblem {

    List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        int n = queries[0].length();
        for (var s : queries) {
            for (var t : dictionary) {
                int cnt = 0;
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) != t.charAt(i)) {
                        cnt++;
                    }
                }
                if (cnt < 3) {
                    ans.add(s);
                    break;
                }
            }
        }
        return ans;
    }

}
