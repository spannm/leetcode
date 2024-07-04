package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1178. Number of Valid Words for Each Puzzle.
 */
class Problem1178 extends LeetcodeProblem {

    List<Integer> findNumOfValidWords(String[] _words, String[] _puzzles) {
        Map<Integer, Integer> cnt = new HashMap<>(_words.length);
        for (var w : _words) {
            int mask = 0;
            for (int i = 0; i < w.length(); i++) {
                mask |= 1 << w.charAt(i) - 'a';
            }
            cnt.merge(mask, 1, Integer::sum);
        }
        List<Integer> ans = new ArrayList<>();
        for (var p : _puzzles) {
            int mask = 0;
            for (int i = 0; i < p.length(); i++) {
                mask |= 1 << p.charAt(i) - 'a';
            }
            int x = 0;
            int i = p.charAt(0) - 'a';
            for (int j = mask; j > 0; j = j - 1 & mask) {
                if ((j >> i & 1) == 1) {
                    x += cnt.getOrDefault(j, 0);
                }
            }
            ans.add(x);
        }
        return ans;
    }

}
