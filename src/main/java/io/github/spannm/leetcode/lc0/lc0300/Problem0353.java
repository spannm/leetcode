package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class Problem0353 extends LeetcodeProblem {

    static class SnakeGame {
        private final Set<Integer>   set;
        private final Deque<Integer> body;
        private final int[][]        food;
        private int                  score;
        private int                  foodIndex;
        private final int            width;
        private final int            height;

        SnakeGame(int _width, int _height, int[][] _food) {
            set = new HashSet<>();
            set.add(0);
            body = new LinkedList<>();
            body.offerLast(0);
            food = _food;
            width = _width;
            height = _height;
        }

        int move(String _direction) {
            if (score == -1) {
                return -1;
            }

            int rowHead = body.peekFirst() / width;
            int colHead = body.peekFirst() % width;
            switch (_direction) {
                case "U" -> rowHead--;
                case "D" -> rowHead++;
                case "L" -> colHead--;
                default -> colHead++;
            }
            int newHead = rowHead * width + colHead;

            set.remove(body.peekLast());

            if (set.contains(newHead) || rowHead < 0 || colHead < 0 || rowHead >= height || colHead >= width) {
                score = -1;
                return score;
            }

            set.add(newHead);
            body.offerFirst(newHead);

            if (foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]) {
                set.add(body.peekLast());
                foodIndex++;
                return ++score;
            }

            body.pollLast();
            return score;

        }
    }

}
