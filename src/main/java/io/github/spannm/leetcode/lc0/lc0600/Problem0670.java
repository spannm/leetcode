package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0670 extends LeetcodeProblem {

    int maximumSwap(int _num) {
        String numStr = String.valueOf(_num);
        int max = _num;
        for (int i = 0; i < numStr.length() - 1; i++) {
            for (int j = i + 1; j < numStr.length(); j++) {
                if (numStr.charAt(i) < numStr.charAt(j)) {
                    StringBuilder sb = new StringBuilder(numStr);
                    sb.replace(i, i + 1, String.valueOf(numStr.charAt(j)));
                    sb.replace(j, j + 1, String.valueOf(numStr.charAt(i)));
                    max = Math.max(max, Integer.parseInt(sb.toString()));
                }
            }
        }
        return max;
    }

}
