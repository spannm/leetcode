package io.github.spannm.leetcode.lc2.lc2800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 2812. Find the Safest Path in a Grid.
 */
class Problem2812 extends LeetcodeProblem {

    int maximumSafenessFactor(List<List<Integer>> _grid) {
        int sz = _grid.size();
        if (_grid.get(0).get(0) == 1 || _grid.get(sz - 1).get(sz - 1) == 1) {
            return 0;
        }

        Deque<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[sz][sz];
        int inf = 1 << 30;
        Arrays.stream(dist).forEach(a -> Arrays.fill(a, inf));

        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                if (_grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[] {i, j});
                }
            }
        }
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int i = p[0];
            int j = p[1];
            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k];
                int y = j + dirs[k + 1];
                if (x >= 0 && x < sz && y >= 0 && y < sz && dist[x][y] == inf) {
                    dist[x][y] = dist[i][j] + 1;
                    q.offer(new int[] {x, y});
                }
            }
        }
        List<int[]> t = IntStream.range(0, sz)
            .boxed()
            .flatMap(i -> IntStream.range(0, sz).mapToObj(j -> new int[] {dist[i][j], i, j}))
            .sorted((a, b) -> Integer.compare(b[0], a[0]))
            .toList();

        UnionFind uf = new UnionFind(sz * sz);
        for (int[] p : t) {
            int d = p[0];
            int i = p[1];
            int j = p[2];
            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k];
                int y = j + dirs[k + 1];
                if (x >= 0 && x < sz && y >= 0 && y < sz && dist[x][y] >= d) {
                    uf.union(i * sz + j, x * sz + y);
                }
            }
            if (uf.find(0) == uf.find(sz * sz - 1)) {
                return d;
            }
        }
        return 0;
    }

    static class UnionFind {
        private final int[] p;

        UnionFind(int _n) {
            p = new int[_n];
            for (int i = 0; i < _n; i++) {
                p[i] = i;
            }
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) {
                return false;
            }
            p[pa] = pb;
            return true;
        }

        int find(int x) {
            if (p[x] != x) {
                p[x] = find(p[x]);
            }
            return p[x];
        }

    }

}
