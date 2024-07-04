package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Map;
import java.util.TreeMap;

class Problem1859 extends LeetcodeProblem {

    String sortSentence(String _s) {
        Map<Integer, String> map = new TreeMap<>();
        for (String word : _s.split(" ")) {
            int key = Integer.parseInt(word.charAt(word.length() - 1) + "");
            map.put(key, word.substring(0, word.length() - 1));
        }
        StringBuilder sb = new StringBuilder();
        for (String val : map.values()) {
            sb.append(val)
                .append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

}
