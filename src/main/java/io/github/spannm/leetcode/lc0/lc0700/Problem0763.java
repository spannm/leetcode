package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0763 extends LeetcodeProblem {

    List<Integer> partitionLabels(String _s) {
        List<Integer> result = new ArrayList<>();
        int[] last = new int[26];
        for (int i = 0; i < _s.length(); i++) {
            last[_s.charAt(i) - 'a'] = i;
        }
        int end = 0;
        int start = 0;
        for (int i = 0; i < _s.length(); i++) {
            end = Math.max(end, last[_s.charAt(i) - 'a']);
            if (end == i) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }

}
