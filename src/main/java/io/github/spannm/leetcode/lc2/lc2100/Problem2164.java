package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Problem2164 extends LeetcodeProblem {

    int[] sortEvenOdd(int[] _nums) {
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        for (int i = 0; i < _nums.length; i++) {
            if (i % 2 == 0) {
                evens.add(_nums[i]);
            } else {
                odds.add(_nums[i]);
            }
        }
        odds.sort(Comparator.reverseOrder());
        Collections.sort(evens);
        int[] ans = new int[_nums.length];
        for (int i = 0, j = 0, k = 0; i < _nums.length; i++) {
            if (i % 2 == 0) {
                ans[i] = evens.get(j++);
            } else {
                ans[i] = odds.get(k++);
            }
        }
        return ans;
    }

}
