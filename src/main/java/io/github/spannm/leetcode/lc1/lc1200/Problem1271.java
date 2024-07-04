package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Set;

class Problem1271 extends LeetcodeProblem {

    String toHexspeak(String _num) {
        String hexStr = Long.toHexString(Long.parseLong(_num));
        StringBuilder sb = new StringBuilder();
        Set<Character> set = Set.of('A', 'B', 'C', 'D', 'E', 'F', '1', '0', 'a', 'b', 'c', 'd', 'e', 'f');
        for (char c : hexStr.toCharArray()) {
            if (!set.contains(c)) {
                return "ERROR";
            } else if (c == '1') {
                sb.append("I");
            } else if (c == '0') {
                sb.append("O");
            } else {
                sb.append(Character.toUpperCase(c));
            }
        }
        return sb.toString();
    }

}
