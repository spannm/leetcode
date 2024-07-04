package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.PriorityQueue;
import java.util.Queue;

class Problem0499 extends LeetcodeProblem {

    String findShortestWay(int[][] _maze, int[] _ball, int[] _hole) {

        final int[] directions = new int[] {-1, 0, 1, 0, -1};
        Queue<Point> heap = new PriorityQueue<>();
        heap.offer(new Point(_ball[0], _ball[1], 0, ""));
        int nbRows = _maze.length;
        int nbCols = _maze[0].length;
        Point[][] points = new Point[nbRows][nbCols];
        for (int i = 0; i < nbRows * nbCols; i++) {
            points[i / nbCols][i % nbCols] = new Point(i / nbCols, i % nbCols);
        }
        String[] ds = new String[] {"u", "r", "d", "l"};
        while (!heap.isEmpty()) {
            Point curr = heap.poll();
            if (points[curr.x][curr.y].compareTo(curr) <= 0) {
                continue;
            }
            points[curr.x][curr.y] = curr;
            for (int i = 0; i < directions.length - 1; i++) {
                int x = curr.x;
                int y = curr.y;
                int distance = curr.distance;

                while (x >= 0 && y >= 0 && x < nbRows && y < nbCols && _maze[x][y] == 0 && (x != _hole[0] || y != _hole[1])) {
                    x += directions[i];
                    y += directions[i + 1];
                    distance++;
                }
                if (x != _hole[0] || y != _hole[1]) {
                    x -= directions[i];
                    y -= directions[i + 1];
                    distance--;
                }
                heap.offer(new Point(x, y, distance, curr.path + ds[i]));
            }
        }
        return points[_hole[0]][_hole[1]].distance == Integer.MAX_VALUE ? "impossible" : points[_hole[0]][_hole[1]].path;
    }

    static class Point implements Comparable<Point> {
        private final int    x;
        private final int    y;
        private final int    distance;
        private final String path;

        Point(int _x, int _y) {
            x = _x;
            y = _y;
            distance = Integer.MAX_VALUE;
            path = "";
        }

        Point(int _x, int _y, int _distance, String _path) {
            x = _x;
            y = _y;
            distance = _distance;
            path = _path;
        }

        @Override
        public int compareTo(Point _o) {
            return distance == _o.distance ? path.compareTo(_o.path) : distance - _o.distance;
        }
    }

}
