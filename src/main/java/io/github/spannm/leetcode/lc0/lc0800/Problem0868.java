package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0868 extends LeetcodeProblem {

    int binaryGap(int _n) {
        String bin = Integer.toBinaryString(_n);
        List<Integer> oneIndexes = new ArrayList<>();
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '1') {
                oneIndexes.add(i);
            }
        }
        int maxGap = 0;
        for (int i = 0; i < oneIndexes.size() - 1; i++) {
            maxGap = Math.max(oneIndexes.get(i + 1) - oneIndexes.get(i), maxGap);
        }
        return maxGap;
    }

}
