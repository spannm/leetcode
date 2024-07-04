package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1389 extends LeetcodeProblem {

    int[] createTargetArray(int[] _nums, int[] _index) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < _nums.length; i++) {
            list.add(_index[i], _nums[i]);
        }
        int[] target = new int[list.size()];
        for (int i = 0; i < target.length; i++) {
            target[i] = list.get(i);
        }
        return target;
    }

}
