package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/diagonal-traverse-ii/">1424. Diagonal Traverse II</a>.
 */
class Problem1424 extends LeetcodeProblem {

    int[] findDiagonalOrder(List<List<Integer>> _nums) {
        int outLen = 0;
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> rowSizes = _nums.stream().map(List::size).toList();

        for (int r = 0; r < _nums.size(); r++) {
            List<Integer> row = _nums.get(r);

            for (int c = 0; c < rowSizes.get(r); c++) {
                int idxList = r + c;

                if (lists.size() < idxList + 1) {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(row.get(c));
                    lists.add(newList);
                } else {
                    lists.get(idxList).add(row.get(c));
                }

                outLen++;
            }
        }

        int[] output = new int[outLen];
        int idxOut = 0;
        for (List<Integer> list : lists) {
            for (int i = list.size() - 1; i >= 0; i--) {
                output[idxOut++] = list.get(i);
            }
        }
        return output;
    }

}
