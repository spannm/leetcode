package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0294 extends LeetcodeProblem {

    boolean canWin(String _s) {
        List<String> res = new ArrayList<>();
        char[] charArray = _s.toCharArray();
        for (int i = 0; i < _s.length() - 1; i++) {
            if (charArray[i] == '+' && charArray[i + 1] == '+') {

                charArray[i] = '-';
                charArray[i + 1] = '-';
                res.add(String.valueOf(charArray));

                charArray[i] = '+';
                charArray[i + 1] = '+';
            }
        }
        for (String str : res) {
            if (!canWin(str)) {
                return true;
            }
        }
        return false;
    }

}
