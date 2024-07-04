package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 1554. Strings Differ by One Character.
 */
class Problem1554 extends LeetcodeProblem {

    boolean differByOne(String[] dict) {
        Set<String> s = new HashSet<>();
        for (String word : dict) {
            for (int i = 0; i < word.length(); i++) {
                String t = word.substring(0, i) + "*" + word.substring(i + 1);
                if (s.contains(t)) {
                    return true;
                }
                s.add(t);
            }
        }
        return false;
    }

}
