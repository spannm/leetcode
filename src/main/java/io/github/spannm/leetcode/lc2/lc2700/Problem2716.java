package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem2716 extends LeetcodeProblem {

    int minimizedStringLength(String _s) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < _s.length(); i++) {
            if (set.add(_s.charAt(i))) {
                sb.append(_s.charAt(i));
            }
        }
        return sb.length();
    }

}
