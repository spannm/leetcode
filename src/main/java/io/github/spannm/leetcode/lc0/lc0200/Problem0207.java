package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/course-schedule/description/">207. Course Schedule</a>.
 */
class Problem0207 extends LeetcodeProblem {

    private static final byte VISITING = 1;
    private static final byte VISITED  = 2;

    boolean canFinish(final int _numCourses, final int[][] _prerequisites) {
        final List<List<Integer>> courseGraph = new ArrayList<>(_numCourses);
        for (int i = 0; i < _numCourses; i++) {
            courseGraph.add(new ArrayList<>(_numCourses));
        }
        for (int[] p : _prerequisites) {
            int prerequisite = p[1];
            int course = p[0];
            courseGraph.get(course).add(prerequisite);
        }

        byte[] visitStatus = new byte[_numCourses];
        for (int course = 0; course < _numCourses; course++) {
            // if there is a cycle, return false
            if (detectCycle(course, courseGraph, visitStatus)) {
                return false;
            }
        }
        return true;
    }

    static boolean detectCycle(final int _course, final List<List<Integer>> _courseList, final byte[] _visitStatus) {
        if (VISITING == _visitStatus[_course]) {
            return true;
        } else if (VISITED == _visitStatus[_course]) {
            return false;
        }

        _visitStatus[_course] = VISITING;

        for (int next : _courseList.get(_course)) {
            if (detectCycle(next, _courseList, _visitStatus)) {
                return true;
            }
        }

        _visitStatus[_course] = VISITED;
        return false;
    }

}
