package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.api.Test;

class Problem0352Test extends LeetcodeBaseTest {

    @Test
    void test() {
        Problem0352.SummaryRanges summaryRanges = new Problem0352.SummaryRanges();
        summaryRanges.addNum(1); // arr = [1]
        assertArrayEquals(new int[][] {new int[] {1, 1}},
            summaryRanges.getIntervals()); // return [[1, 1]]

        summaryRanges.addNum(3); // arr = [1, 3]
        assertArrayEquals(new int[][] {new int[] {1, 1}, new int[] {3, 3}},
            summaryRanges.getIntervals()); // return [[1, 1], [3, 3]]

        summaryRanges.addNum(7); // arr = [1, 3, 7]
        assertArrayEquals(new int[][] {new int[] {1, 1}, new int[] {3, 3}, new int[] {7, 7}},
            summaryRanges.getIntervals()); // return [[1, 1], [3, 3], [7, 7]]

        summaryRanges.addNum(2); // arr = [1, 2, 3, 7]
        assertArrayEquals(new int[][] {new int[] {1, 3}, new int[] {7, 7}},
            summaryRanges.getIntervals()); // return [[1, 3], [7, 7]]

        summaryRanges.addNum(6); // arr = [1, 2, 3, 6, 7]
        assertArrayEquals(new int[][] {new int[] {1, 3}, new int[] {6, 7}},
            summaryRanges.getIntervals()); // return [[1, 3], [6, 7]]
    }

}
