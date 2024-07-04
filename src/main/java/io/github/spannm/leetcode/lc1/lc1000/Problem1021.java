package io.github.spannm.leetcode.lc1.lc1000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1021 extends LeetcodeProblem {

    String removeOuterParentheses(String _s) {
        List<String> primitives = new ArrayList<>();
        for (int i = 1; i < _s.length(); i++) {
            int initialI = i - 1;
            int left = 1;
            while (i < _s.length() && left > 0) {
                if (_s.charAt(i) == '(') {
                    left++;
                } else {
                    left--;
                }
                i++;
            }
            primitives.add(_s.substring(initialI, i));
        }
        StringBuilder sb = new StringBuilder();
        for (String primitive : primitives) {
            sb.append(primitive, 1, primitive.length() - 1);
        }
        return sb.toString();
    }

}
