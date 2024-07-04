package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Problem1451 extends LeetcodeProblem {

    String arrangeWords(String _text) {
        Map<Integer, List<String>> map = new TreeMap<>();
        for (String word : _text.split(" ")) {
            map.computeIfAbsent(word.length(), k -> new ArrayList<>()).add(word.toLowerCase());
        }
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (List<String> strings : map.values()) {
            for (String str : strings) {
                if (first) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                    first = false;
                }
                sb.append(str).append(" ");
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

}
