package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 761. Special Binary String.
 */
class Problem0761 extends LeetcodeProblem {

    String makeLargestSpecial(String _s) {
        if ("".equals(_s)) {
            return "";
        }
        List<String> ans = new ArrayList<>();
        int cnt = 0;
        for (int i = 0, j = 0; i < _s.length(); i++) {
            cnt += _s.charAt(i) == '1' ? 1 : -1;
            if (cnt == 0) {
                String t = "1" + makeLargestSpecial(_s.substring(j + 1, i)) + "0";
                ans.add(t);
                j = i + 1;
            }
        }
        ans.sort(Comparator.reverseOrder());
        return String.join("", ans);
    }

}
