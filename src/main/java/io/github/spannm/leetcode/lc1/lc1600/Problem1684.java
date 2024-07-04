package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem1684 extends LeetcodeProblem {

    int countConsistentStrings(String _allowed, String[] _words) {
        Set<Character> set = new HashSet<>();
        for (char c : _allowed.toCharArray()) {
            set.add(c);
        }
        int count = 0;
        for (String word : _words) {
            boolean isConsistent = true;
            for (char c : word.toCharArray()) {
                if (!set.contains(c)) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) {
                count++;
            }
        }
        return count;
    }

}
