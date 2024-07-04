package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1844 extends LeetcodeProblem {

    String replaceDigits(String _s) {
        StringBuilder sb = new StringBuilder();
        for (char c : _s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            } else {
                sb.append((char) (sb.charAt(sb.length() - 1) + Character.getNumericValue(c)));
            }
        }
        return sb.toString();
    }

}
