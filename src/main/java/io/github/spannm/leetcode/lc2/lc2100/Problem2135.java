package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

/**
 * 2135. Count Words Obtained After Adding a Letter.
 */
class Problem2135 extends LeetcodeProblem {

    int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> s = new HashSet<>();
        for (String word : startWords) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= 1 << c - 'a';
            }
            s.add(mask);
        }
        int ans = 0;
        for (String word : targetWords) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= 1 << c - 'a';
            }
            for (char c : word.toCharArray()) {
                int t = mask ^ 1 << c - 'a';
                if (s.contains(t)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

}
