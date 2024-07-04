package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0438 extends LeetcodeProblem {

    List<Integer> findAnagrams(String _s, String _p) {
        List<Integer> result = new ArrayList<>();
        int[] hash = new int[26];
        for (char c : _p.toCharArray()) {
            hash[c - 'a']++;
        }
        int start = 0;
        int end = 0;
        int count = _p.length();
        while (end < _s.length()) {
            if (hash[_s.charAt(end) - 'a'] > 0) {
                count--;
            }
            hash[_s.charAt(end) - 'a']--;
            end++;

            if (count == 0) {
                result.add(start);
            }

            if (end - start == _p.length()) {
                if (hash[_s.charAt(start) - 'a'] >= 0) {
                    count++;
                }
                hash[_s.charAt(start) - 'a']++;
                start++;
            }
        }
        return result;
    }

}
