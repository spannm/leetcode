package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Objects;
import java.util.Stack;

class Problem1496 extends LeetcodeProblem {

    boolean isPathCrossing(String _path) {
        Stack<Coord> visited = new Stack<>();
        visited.add(new Coord(0, 0));
        for (char c : _path.toCharArray()) {
            Coord lst = visited.peek();
            Coord nxt = switch (c) {
                case 'N' ->
                    nxt = new Coord(lst.x, lst.y + 1);
                case 'S' ->
                    nxt = new Coord(lst.x, lst.y - 1);
                case 'E' ->
                    nxt = new Coord(lst.x - 1, lst.y);
                case 'W' ->
                    nxt = new Coord(lst.x + 1, lst.y);
                default -> null;
            };
            if (visited.contains(nxt)) {
                return true;
            }
            visited.add(nxt);
        }
        return false;
    }

    static class Coord {
        private final int x;
        private final int y;

        Coord(int _x, int _y) {
            x = _x;
            y = _y;
        }

        @Override
        public boolean equals(Object _o) {
            if (this == _o) {
                return true;
            } else if (_o == null || getClass() != _o.getClass()) {
                return false;
            }
            Coord coord = (Coord) _o;
            return x == coord.x && y == coord.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
