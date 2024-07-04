package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0482 extends LeetcodeProblem {

    String licenseKeyFormatting(String _s, int _k) {
        StringBuilder sb = new StringBuilder();
        char[] schars = _s.toCharArray();
        for (int i = _s.length() - 1, j = 0; i >= 0;) {
            if (j < _k) {
                if (schars[i] != '-') {
                    if (schars[i] >= 'a' && schars[i] <= 'z') {
                        sb.append(Character.toUpperCase(schars[i]));
                    } else {
                        sb.append(schars[i]);
                    }
                    j++;
                }
                i--;
            } else if (j == _k) {
                j = 0;
                sb.append('-');
            }
        }
        if (sb.length() > 1 && sb.substring(sb.length() - 1).equals("-")) {
            return sb.reverse().substring(1);
        }
        return sb.reverse().toString();
    }

}
