package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/parallel-courses-iii/">2050. Parallel Courses III</a>.
 */
class Problem2050 extends LeetcodeProblem {

    int minimumTime(int _n, int[][] _relations, int[] _time) {
        /* calculate parent of every course */
        List<List<Integer>> parent = new ArrayList<>(_n);
        IntStream.range(0, _n).forEach(i -> parent.add(new ArrayList<>()));

        for (int[] relation : _relations) {
            int par = relation[0];
            int child = relation[1];
            parent.get(child - 1).add(par - 1);
        }
        /* parent of every course calculated */
        /* now find the minimum time to calculate every course */
        int[] min = new int[_n];
        Arrays.fill(min, -1);
        int result = 0;
        for (int i = 0; i < _n; i++) {
            result = Math.max(result, minimumTimeToCompleteACourse(_time, parent, i, min));
        }
        return result;
    }

    /*
     * Method to calculate minimum time for every course using DP Memoization. Here min[] is used to store previously
     * computed vales.
     */
    static int minimumTimeToCompleteACourse(int[] _time, List<List<Integer>> _parent, int _course, int[] _dp) {
        // if course is not dependent on any course then simple return its time
        if (_parent.get(_course).isEmpty()) {
            return _dp[_course] = _time[_course];
        }

        // Otherwise we need to calculate the maximum time taken by all the parents of the course
        if (_dp[_course] != -1) {
            return _dp[_course];
        }
        int duration = 0;
        for (int i : _parent.get(_course)) {
            duration = Math.max(duration, minimumTimeToCompleteACourse(_time, _parent, i, _dp));
        }
        return _dp[_course] = duration + _time[_course];
    }

}
