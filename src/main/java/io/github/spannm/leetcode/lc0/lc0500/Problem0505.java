package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.LinkedList;
import java.util.Queue;

class Problem0505 extends LeetcodeProblem {

    int shortestDistance(int[][] _maze, int[] _start, int[] _destination) {

        final int[] directions = new int[] {-1, 0, 1, 0, -1};
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(_start[0], _start[1], 0));
        int nbRows = _maze.length;
        int nbCols = _maze[0].length;
        int[][] length = new int[nbRows][nbCols];
        for (int i = 0; i < nbRows * nbCols; i++) {
            length[i / nbCols][i % nbCols] = Integer.MAX_VALUE;
        }

        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            if (length[curr.x][curr.y] <= curr.distance) {
                continue;
            }
            length[curr.x][curr.y] = curr.distance;
            for (int i = 0; i < directions.length - 1; i++) {
                int x = curr.x;
                int y = curr.y;
                int distance = curr.distance;

                while (x >= 0 && y >= 0 && x < nbRows && y < nbCols && _maze[x][y] == 0) {
                    x += directions[i];
                    y += directions[i + 1];
                    distance++;
                }
                x -= directions[i];
                y -= directions[i + 1];
                distance--;
                queue.offer(new Point(x, y, distance));
            }
        }
        return length[_destination[0]][_destination[1]] == Integer.MAX_VALUE ? -1 : length[_destination[0]][_destination[1]];

    }

    static class Point {
        private final int x;
        private final int y;
        private final int distance;

        Point(int _x, int _y, int _distance) {
            x = _x;
            y = _y;
            distance = _distance;
        }
    }

}
