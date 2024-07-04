package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Problem0323 extends LeetcodeProblem {

    int countComponents(int _n, int[][] _edges) {
        if (_n <= 1) {
            return _n;
        }

        List<List<Integer>> adList = new ArrayList<>();
        for (int i = 0; i < _n; i++) {
            adList.add(new ArrayList<>());
        }

        for (int[] edge : _edges) {
            adList.get(edge[0]).add(edge[1]);
            adList.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[_n];
        int count = 0;
        for (int i = 0; i < _n; i++) {
            if (!visited[i]) {
                count++;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                while (!q.isEmpty()) {
                    int index = q.poll();
                    visited[index] = true;
                    for (int j : adList.get(index)) {
                        if (!visited[j]) {
                            q.offer(j);
                        }
                    }
                }
            }
        }

        return count;
    }

}
