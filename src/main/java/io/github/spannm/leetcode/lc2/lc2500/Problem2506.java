package io.github.spannm.leetcode.lc2.lc2500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2506. Count Pairs Of Similar Strings.
 */
class Problem2506 extends LeetcodeProblem {

    int similarPairs(String[] words) {
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (var w : words) {
            int v = 0;
            for (int i = 0; i < w.length(); i++) {
                v |= 1 << w.charAt(i) - 'a';
            }
            ans += cnt.getOrDefault(v, 0);
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        }
        return ans;
    }

}
