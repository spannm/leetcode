package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem0675 extends LeetcodeProblem {

    int cutOffTree(List<List<Integer>> _forest) {
        if (_forest == null || _forest.isEmpty() || _forest.get(0).get(0) == 0) {
            return -1;
        }
        int m = _forest.size();
        int n = _forest.get(0).size();
        Queue<Tree> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.height));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (_forest.get(i).get(j) > 1) {
                    heap.offer(new Tree(i, j, _forest.get(i).get(j)));
                }
            }
        }

        int sum = 0;
        Tree start = new Tree();
        while (!heap.isEmpty()) {
            Tree curr = heap.poll();
            int step = bfs(_forest, curr, start, m, n);
            if (step == -1) {
                return -1;
            }
            sum += step;
            start = curr;
        }
        return sum;
    }

    static int bfs(List<List<Integer>> _forest, Tree _target, Tree _start, int _m, int _n) {
        int[] dirs = new int[] {0, 1, 0, -1, 0};
        boolean[][] visited = new boolean[_m][_n];
        Queue<Tree> queue = new LinkedList<>();
        queue.offer(_start);
        visited[_start.x][_start.y] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Tree tree = queue.poll();
                if (tree.x == _target.x && tree.y == _target.y) {
                    return step;
                }

                for (int i = 0; i < 4; i++) {
                    int nextX = tree.x + dirs[i];
                    int nextY = tree.y + dirs[i + 1];
                    if (nextX < 0 || nextY < 0 || nextX >= _m || nextY >= _n || visited[nextX][nextY] || _forest.get(nextX).get(nextY) == 0) {
                        continue;
                    }
                    queue.offer(new Tree(nextX, nextY, _forest.get(nextX).get(nextY)));
                    visited[nextX][nextY] = true;
                }
            }
            step++;
        }
        return -1;
    }

    static class Tree {
        private final int x;
        private final int y;
        private final int height;

        Tree(int _x, int _y, int _height) {
            x = _x;
            y = _y;
            height = _height;
        }

        Tree() {
            x = 0;
            y = 0;
            height = 0;
        }
    }

}
