package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * 210. Course Schedule II.
 */
class Problem0210 extends LeetcodeProblem {

    int[] findOrder(int _numCourses, int[][] _prerequisites) {
        @SuppressWarnings("unchecked")
        List<Integer>[] g = new List[_numCourses];
        Arrays.setAll(g, k -> new ArrayList<>());
        int[] indeg = new int[_numCourses];
        for (int[] p : _prerequisites) {
            int a = p[0];
            int b = p[1];
            g[b].add(a);
            indeg[a]++;
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < _numCourses; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
            }
        }
        int[] ans = new int[_numCourses];
        int cnt = 0;
        while (!q.isEmpty()) {
            int i = q.poll();
            ans[cnt++] = i;
            for (int j : g[i]) {
                if (--indeg[j] == 0) {
                    q.offer(j);
                }
            }
        }
        return cnt == _numCourses ? ans : new int[0];
    }

}
