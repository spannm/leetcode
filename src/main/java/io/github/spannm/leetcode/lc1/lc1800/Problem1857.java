package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/largest-color-value-in-a-directed-graph/"> 1857. Largest Color Value in a
 * Directed Graph</a>.
 */
class Problem1857 extends LeetcodeProblem {

    int largestPathValue(final String _colors, final int[][] _edges) {
        final int nbColors = _colors.length();
        int[] indegrees = new int[nbColors];

        List<List<Integer>> graph = new ArrayList<>(nbColors);
        for (int i = 0; i < nbColors; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : _edges) {
            graph.get(edge[0]).add(edge[1]);
            indegrees[edge[1]]++;
        }

        Queue<Integer> zeroIndegree = new LinkedList<>();
        for (int i = 0; i < nbColors; i++) {
            if (indegrees[i] == 0) {
                zeroIndegree.offer(i);
            }
        }
        int[][] counts = new int[nbColors][26]; // alphabet
        for (int i = 0; i < nbColors; i++) {
            counts[i][_colors.charAt(i) - 'a']++;
        }

        int max = 0;
        int visited = 0;
        while (!zeroIndegree.isEmpty()) {
            int u = zeroIndegree.poll();
            visited++;
            for (int v : graph.get(u)) {
                for (int i = 0; i < 26; i++) {
                    counts[v][i] = Math.max(counts[v][i], counts[u][i] + (_colors.charAt(v) - 'a' == i ? 1 : 0));
                }
                indegrees[v]--;
                if (indegrees[v] == 0) {
                    zeroIndegree.offer(v);
                }
            }
            max = Math.max(max, Arrays.stream(counts[u]).max().getAsInt());
        }
        return visited == nbColors ? max : -1;
    }

}
