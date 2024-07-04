package io.github.spannm.leetcode.lc2.lc2700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2744. Find Maximum Number of String Pairs.
 */
class Problem2744 extends LeetcodeProblem {

    int maximumNumberOfStringPairs(String[] words) {
        Map<String, Integer> cnt = new HashMap<>(words.length);
        int ans = 0;
        for (String w : words) {
            ans += cnt.getOrDefault(w, 0);
            cnt.merge(new StringBuilder(w).reverse().toString(), 1, Integer::sum);
        }
        return ans;
    }

}
