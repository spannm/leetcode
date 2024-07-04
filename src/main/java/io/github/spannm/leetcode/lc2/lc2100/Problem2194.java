package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem2194 extends LeetcodeProblem {

    List<String> cellsInRange(String _s) {
        char start = _s.charAt(0);
        int num1 = Integer.parseInt(_s.charAt(1) + "");
        char end = _s.charAt(3);
        int num2 = Integer.parseInt(_s.charAt(4) + "");
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char startChar = start; startChar <= end; startChar++) {
            for (int c = num1; c <= num2; c++) {
                sb.setLength(0);
                sb.append(startChar);
                sb.append(c);
                ans.add(sb.toString());
            }
        }
        Collections.sort(ans);
        return ans;
    }

}
