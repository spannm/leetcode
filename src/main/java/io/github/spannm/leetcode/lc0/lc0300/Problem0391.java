package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Problem0391 extends LeetcodeProblem {

    boolean isRectangleCover(int[][] _rectangles) {
        if (_rectangles.length == 0 || _rectangles[0].length == 0) {
            return false;
        }

        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;

        Set<String> set = new HashSet<>();
        int area = 0;

        for (int[] rect : _rectangles) {
            x1 = Math.min(rect[0], x1);
            y1 = Math.min(rect[1], y1);
            x2 = Math.max(rect[2], x2);
            y2 = Math.max(rect[3], y2);

            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);

            List.of(rect[0] + " " + rect[1],
                rect[0] + " " + rect[3],
                rect[2] + " " + rect[3],
                rect[2] + " " + rect[1]).forEach(s -> {
                    if (!set.add(s)) {
                        set.remove(s);
                    }
                });
        }

        if (!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) || !set.contains(
            x2 + " " + y1) || !set.contains(x2 + " " + y2) || set.size() != 4) {
            return false;
        }

        return area == (x2 - x1) * (y2 - y1);
    }

}
