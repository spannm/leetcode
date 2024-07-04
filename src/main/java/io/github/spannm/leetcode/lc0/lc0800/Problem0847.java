package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/shortest-path-visiting-all-nodes/">847. Shortest Path Visiting All Nodes</a>.
 */
class Problem0847 extends LeetcodeProblem {

    int shortestPathLength(int[][] _graph) {

        final int len = _graph.length;

        int targetState = (1 << len) - 1;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            q.add(new int[] {i, 1 << i});
        }

        boolean[][] visited = new boolean[len][1 << len];

        int level = 0;

        OUTER: while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int[] current = q.poll();
                int nodeVal = current[0];
                int state = current[1];

                if (state == targetState) {
                    break OUTER;
                }
                if (visited[nodeVal][state]) {
                    // Ignore visited state
                    continue;
                }

                // Mark the current node value + state combination as true
                visited[nodeVal][state] = true;

                for (int next : _graph[nodeVal]) {
                    q.add(new int[] {next, state | 1 << next});
                }
            }
            // Increasing the level
            level++;
        }

        q = null;
        visited = null;

        return level;
    }

}
