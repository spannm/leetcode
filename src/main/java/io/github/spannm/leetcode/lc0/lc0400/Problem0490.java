package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.LinkedList;
import java.util.Queue;

class Problem0490 extends LeetcodeProblem {

    boolean hasPath(int[][] _maze, int[] _start, int[] _destination) {
        if (_start[0] == _destination[0] && _destination[0] == _destination[1]) {
            return true;
        }
        final int[] directions = new int[] {-1, 0, 1, 0, -1};
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(_start[0], _start[1]));
        int nbRows = _maze.length;
        int nbCols = _maze[0].length;
        boolean[][] visited = new boolean[nbRows][nbCols];
        visited[_start[0]][_start[1]] = true;

        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            int x = curr.x;
            int y = curr.y;
            for (int i = 0; i < directions.length - 1; i++) {
                int xx = x;
                int yy = y;
                while (xx >= 0 && yy >= 0 && xx < nbRows && yy < nbCols && _maze[xx][yy] == 0) {
                    xx += directions[i];
                    yy += directions[i + 1];
                }
                xx -= directions[i];
                yy -= directions[i + 1];
                if (visited[xx][yy]) {
                    continue;
                }
                visited[xx][yy] = true;
                if (_destination[0] == xx && _destination[1] == yy) {
                    return true;
                }
                queue.offer(new Point(xx, yy));
            }
        }
        return false;
    }

    static class Point {
        private final int x;
        private final int y;

        Point(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }

}
