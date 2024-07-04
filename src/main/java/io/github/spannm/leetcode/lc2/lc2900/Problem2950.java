package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * 2950. Number of Divisible Substrings.
 */
class Problem2950 extends LeetcodeProblem {

    int countDivisibleSubstrings(String word) {
        String[] d = {"ab", "cde", "fgh", "ijk", "lmn", "opq", "rst", "uvw", "xyz"};
        int[] mp = new int[26];
        for (int i = 0; i < d.length; i++) {
            for (char c : d[i].toCharArray()) {
                mp[c - 'a'] = i + 1;
            }
        }
        int ans = 0;
        char[] cs = word.toCharArray();
        for (int i = 1; i < 10; i++) {
            Map<Integer, Integer> cnt = new HashMap<>();
            cnt.put(0, 1);
            int s = 0;
            for (char c : cs) {
                s += mp[c - 'a'] - i;
                ans += cnt.getOrDefault(s, 0);
                cnt.merge(s, 1, Integer::sum);
            }
        }
        return ans;
    }

}
