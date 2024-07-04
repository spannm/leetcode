package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Locale;

class Problem2129 extends LeetcodeProblem {

    String capitalizeTitle(String _title) {
        String[] words = _title.split("\\ ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String tmp = words[i].toLowerCase(Locale.ROOT);
            if (words[i].length() <= 2) {
                sb.append(tmp);
            } else {
                sb.append(Character.toUpperCase(tmp.charAt(0))).append(tmp.substring(1));
            }
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}
