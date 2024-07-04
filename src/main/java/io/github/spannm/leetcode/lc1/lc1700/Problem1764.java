package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1764 extends LeetcodeProblem {

    boolean canChoose(int[][] _groups, int[] _nums) {
        List<Integer> numsInt = new ArrayList<>();
        for (int num : _nums) {
            numsInt.add(num);
        }
        int prevIndex = 0;
        for (int[] group : _groups) {
            List<Integer> groupInt = new ArrayList<>();
            for (int num : group) {
                groupInt.add(num);
            }
            int index = Collections.indexOfSubList(numsInt.subList(prevIndex, numsInt.size()), groupInt);
            if (index != -1) {
                prevIndex = index + group.length;
            } else {
                return false;
            }
        }
        return true;
    }

}
