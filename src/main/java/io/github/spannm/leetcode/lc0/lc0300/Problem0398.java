package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Problem0398 extends LeetcodeProblem {

    static class Solution {

        private final int[]  nums;
        private final Random rand = new Random();

        Solution(int[] _nums) {
            nums = _nums;
        }

        int pick(int _target) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == _target) {
                    list.add(i);
                }
            }
            if (list.size() == 1) {
                return list.get(0);
            }
            int randomIndex = rand.nextInt(list.size());
            return list.get(randomIndex);
        }
    }

}
