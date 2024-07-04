package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0986 extends LeetcodeProblem {

    int[][] intervalIntersection(int[][] _firstList, int[][] _secondList) {
        int i = 0;
        int j = 0;
        List<int[]> list = new ArrayList<>();
        while (i < _firstList.length && j < _secondList.length) {
            int start = Math.max(_firstList[i][0], _secondList[j][0]);
            int end = Math.min(_firstList[i][1], _secondList[j][1]);
            if (start <= end) {
                list.add(new int[] {start, end});
            }
            if (end == _firstList[i][1]) {
                i++;
            } else {
                j++;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

}
