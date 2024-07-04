package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2288 extends LeetcodeProblem {

    String discountPrices(String _sentence, int _discount) {
        StringBuilder sb = new StringBuilder();
        String[] words = _sentence.split(" ");
        for (String word : words) {
            if (word.charAt(0) == '$') {
                try {
                    long num = Long.parseLong(word.substring(1));
                    double newNum = Math.round(num * (1 - _discount * 1.0 / 100) * 100.00) / 100.00;
                    sb.append("$")
                        .append(String.format("%.2f", newNum));
                } catch (Exception _ex) {
                    sb.append(word);
                }
            } else {
                sb.append(word);
            }
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

}
