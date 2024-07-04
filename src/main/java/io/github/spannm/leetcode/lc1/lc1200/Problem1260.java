package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Problem1260 extends LeetcodeProblem {

    List<List<Integer>> shiftGrid(int[][] _grid, int _k) {
        int m = _grid.length;
        int n = _grid[0].length;
        int totalNumbers = m * n;
        int start = totalNumbers - _k % totalNumbers;
        LinkedList<List<Integer>> result = new LinkedList<>();
        for (int i = start; i < totalNumbers + start; i++) {
            int moveIndex = i % totalNumbers;
            int moveRow = moveIndex / n;
            int moveColumn = moveIndex % n;
            if ((i - start) % n == 0) {
                result.add(new ArrayList<>());
            }
            result.peekLast().add(_grid[moveRow][moveColumn]);
        }
        return result;
    }

}
