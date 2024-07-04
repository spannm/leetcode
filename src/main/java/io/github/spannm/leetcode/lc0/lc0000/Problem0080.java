package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0080 extends LeetcodeProblem {

    int removeDuplicates(int[] _nums) {
        int len = _nums.length;
        if (len < 3) {
            return len;
        }

        List<Integer> l = new ArrayList<>(List.of(_nums[0], _nums[1]));
        int counter = 0;
        for (int i = 2; i < len; i++) {
            if (_nums[i] != _nums[i - 1]) {
                l.add(_nums[i]);
            } else if (_nums[i] != _nums[i - 2]) {
                l.add(_nums[i]);
            }
        }

        counter = l.size();
        for (int i = 0; i < counter; i++) {
            _nums[i] = l.get(i);
        }
        return counter;
    }

}
