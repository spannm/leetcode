package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * <a href="https://leetcode.com/problems/substring-with-largest-variance/description/">2272. Substring With Largest
 * Variance</a>.
 */
class Problem2272 extends LeetcodeProblem {

    int largestVariance(final String _s) {
        final Map<Character, Integer> freq = new TreeMap<>();
        for (char c : _s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int max = 0;
        final Set<Character> chars = freq.keySet();
        for (char c1 : chars) {
            for (char c2 : chars) {
                if (c1 == c2) {
                    continue;
                }
                int c1Freq = 0;
                int c2Freq = 0;
                int c1Remaining = freq.get(c1); // Keep track of the remaining c1 chars

                for (char c : _s.toCharArray()) {
                    if (c == c1) {
                        c1Freq++;
                        c1Remaining--;
                    }
                    if (c == c2) {
                        c2Freq++;
                    }

                    if (c2Freq < c1Freq && c1Remaining > 0) {
                        c2Freq = 0;
                        c1Freq = 0;
                    }

                    if (c1Freq > 0 && c2Freq > 0) {
                        max = Math.max(max, c2Freq - c1Freq);
                    }
                }
            }
        }
        return max;
    }

}
