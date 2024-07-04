package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1828 extends LeetcodeProblem {

    int[] countPoints(int[][] _points, int[][] _queries) {
        int[] result = new int[_queries.length];
        int i = 0;
        for (int[] query : _queries) {
            int pts = 0;
            for (int[] point : _points) {
                if ((point[0] - query[0]) * (point[0] - query[0]) + (point[1] - query[1]) * (point[1] - query[1]) <= query[2] * query[2]) {
                    pts++;
                }
            }
            result[i++] = pts;
        }
        return result;
    }

}
