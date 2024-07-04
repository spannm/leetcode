package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0830 extends LeetcodeProblem {

    List<List<Integer>> largeGroupPositions(String _s) {
        List<List<Integer>> result = new ArrayList<>();
        char[] chars = _s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len;) {
            char first = chars[i];
            int j = i + 1;
            while (j < len && first == chars[j]) {
                j++;
            }
            if (j - i >= 3) {
                result.add(List.of(i, j - 1));
            }
            i = j;
        }
        return result;
    }

}
