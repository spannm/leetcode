package io.github.spannm.leetcode.lc2.lc2600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * 2610. Convert an Array Into a 2D Array With Conditions.
 */
class Problem2610 extends LeetcodeProblem {

    List<List<Integer>> findMatrix(int[] _nums) {
        int len = _nums.length;
        int[] cnt = new int[len + 1];
        for (int x : _nums) {
            cnt[x]++;
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int x = 1; x <= len; x++) {
            int v = cnt[x];
            for (int j = 0; j < v; j++) {
                if (result.size() <= j) {
                    result.add(new ArrayList<>());
                }
                result.get(j).add(x);
            }
        }
        return result;
    }

}
