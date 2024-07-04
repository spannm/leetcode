package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem0686 extends LeetcodeProblem {

    int repeatedStringMatch(String _a, String _b) {
        Set<Character> set = new HashSet<>();
        for (char c : _a.toCharArray()) {
            set.add(c);
        }
        for (char c : _b.toCharArray()) {
            if (!set.contains(c)) {
                return -1;
            }
        }
        StringBuilder sb = new StringBuilder(_a);
        for (int i = 0; i < _b.length(); i++) {
            if (sb.indexOf(_b) > -1) {
                return i + 1;
            }
            sb.append(_a);
        }
        return -1;
    }

}
