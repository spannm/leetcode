package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem2325 extends LeetcodeProblem {

    String decodeMessage(String _key, String _message) {
        Map<Character, Character> map = new HashMap<>();
        char realChar = 'a';
        for (char c : _key.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (!map.containsKey(c)) {
                map.put(c, realChar);
                realChar++;
            }
            if (map.size() >= 26) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : _message.toCharArray()) {
            sb.append(c == ' ' ? ' ' : map.get(c));
        }
        return sb.toString();
    }

}
