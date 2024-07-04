package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem2351 extends LeetcodeProblem {

    char repeatedCharacter(String _s) {
        Set<Character> set = new HashSet<>();
        for (char c : _s.toCharArray()) {
            if (!set.add(c)) {
                return c;
            }
        }
        return ' ';
    }

}
