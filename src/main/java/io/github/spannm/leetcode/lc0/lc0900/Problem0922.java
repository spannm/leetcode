package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0922 extends LeetcodeProblem {

    int[] sortArrayByParityII(int[] _nums) {
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        for (int num : _nums) {
            if (num % 2 == 0) {
                evens.add(num);
            } else {
                odds.add(num);
            }
        }
        int oddIndex = 0;
        int evenIndex = 0;
        for (int i = 0; i < _nums.length; i++) {
            if (i % 2 == 0) {
                _nums[i] = evens.get(evenIndex++);
            } else {
                _nums[i] = odds.get(oddIndex++);
            }
        }
        return _nums;
    }

}
