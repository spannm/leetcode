package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 797. All Paths From Source to Target.
 */
class Problem0797 extends LeetcodeProblem {

    List<List<Integer>> allPathsSourceTarget(int[][] _graph) {
        int len = _graph.length;
        Queue<List<Integer>> q = new ArrayDeque<>();
        q.offer(List.of(0));
        List<List<Integer>> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            List<Integer> path = q.poll();
            int u = path.get(path.size() - 1);
            if (u == len - 1) {
                ans.add(path);
                continue;
            }
            for (int v : _graph[u]) {
                List<Integer> next = new ArrayList<>(path);
                next.add(v);
                q.offer(next);
            }
        }
        return ans;
    }

}
