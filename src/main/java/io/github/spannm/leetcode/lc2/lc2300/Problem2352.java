package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/equal-row-and-column-pairs/">2352. Equal Row and Column Pairs</a>.
 */
class Problem2352 extends LeetcodeProblem {

    static int equalPairs(final int[][] _grid) {
        List<String> rows = Arrays.stream(_grid).map(Arrays::toString).toList();

        List<String> cols = IntStream.range(0, _grid[0].length)
            .mapToObj(col -> Arrays.toString(Arrays.stream(_grid).mapToInt(ints -> ints[col]).toArray()))
            .toList();

        return rows.stream().mapToInt(row -> cols.stream().filter(c -> c.equals(row)).mapToInt(i -> 1).sum()).sum();
    }

}
