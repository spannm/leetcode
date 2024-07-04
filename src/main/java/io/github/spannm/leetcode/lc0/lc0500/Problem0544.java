package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0544 extends LeetcodeProblem {

    String findContestMatch(int _n) {
        List<String> pairs = new ArrayList<>();
        int left = 1;
        int right = _n;
        while (left < right) {
            pairs.add("(" + left + "," + right + ")");
            left++;
            right--;
        }
        if (_n == 2) {
            return pairs.get(0);
        }
        return generateFinal(pairs, _n / 2);
    }

    private String generateFinal(List<String> _pairs, int _n) {
        if (_n > 2) {
            int size = _pairs.size();
            int left = 0;
            int right = size - 1;
            List<String> newPairs = new ArrayList<>();
            while (left < right) {
                String newPair = "(" + _pairs.get(left) + "," + _pairs.get(right) + ")";
                newPairs.add(newPair);
                left++;
                right--;
            }
            return generateFinal(newPairs, _n / 2);
        }
        return "(" + _pairs.get(0) + "," + _pairs.get(1) + ")";
    }

}
