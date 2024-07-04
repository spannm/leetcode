package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1556 extends LeetcodeProblem {

    String thousandSeparator(int _n) {
        String str = Integer.toString(_n);
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1, j = 1; i >= 0; i--, j++) {
            sb.append(str.charAt(i));
            j++;
            if (j % 3 == 0) {
                sb.append(".");
            }
        }
        String result = sb.reverse().toString();
        if (result.charAt(0) == '.') {
            result = result.substring(1);
        }
        return result;
    }

}
