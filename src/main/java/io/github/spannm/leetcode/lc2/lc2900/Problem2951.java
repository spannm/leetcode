package io.github.spannm.leetcode.lc2.lc2900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 2951. Find the Peaks.
 */
class Problem2951 extends LeetcodeProblem {

    List<Integer> findPeaks(int[] mountain) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i - 1] < mountain[i] && mountain[i + 1] < mountain[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

}
