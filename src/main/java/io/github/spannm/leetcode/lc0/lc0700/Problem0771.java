package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem0771 extends LeetcodeProblem {

    int numJewelsInStones(String _j, String _s) {
        Set<Character> set = new HashSet<>();
        for (char c : _j.toCharArray()) {
            set.add(c);
        }
        int count = 0;
        for (char c : _s.toCharArray()) {
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }

}
