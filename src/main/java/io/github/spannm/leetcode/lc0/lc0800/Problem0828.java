package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 828. Count Unique Characters of All Substrings of a Given String.
 */
class Problem0828 extends LeetcodeProblem {

    int uniqueLetterString(String _s) {
        @SuppressWarnings("unchecked")
        List<Integer>[] d = new List[26];
        Arrays.setAll(d, k -> new ArrayList<>());
        for (int i = 0; i < 26; i++) {
            d[i].add(-1);
        }
        for (int i = 0; i < _s.length(); i++) {
            d[_s.charAt(i) - 'A'].add(i);
        }
        int ans = 0;
        for (var v : d) {
            v.add(_s.length());
            for (int i = 1; i < v.size() - 1; i++) {
                ans += (v.get(i) - v.get(i - 1)) * (v.get(i + 1) - v.get(i));
            }
        }
        return ans;
    }

}
