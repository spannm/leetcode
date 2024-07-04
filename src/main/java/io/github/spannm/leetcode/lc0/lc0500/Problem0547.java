package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/number-of-provinces/">547. Number of Provinces</a>.
 */
class Problem0547 extends LeetcodeProblem {

    static int findCircleNum(int[][] _isConnected) {

        final int sz = _isConnected.length;
        final boolean[] visited = new boolean[sz + 1];
        final Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < sz; i++) {
            if (visited[i]) {
                continue;
            }

            count++;
            q.add(i);
            visited[i] = true;
            while (!q.isEmpty()) {
                Integer vertex = q.poll();
                for (int j = 0; j < _isConnected[0].length; j++) {
                    if (!visited[j] && _isConnected[vertex][j] == 1) {
                        q.add(j);
                        visited[j] = true;
                    }
                }
            }
        }
        return count;
    }

}
