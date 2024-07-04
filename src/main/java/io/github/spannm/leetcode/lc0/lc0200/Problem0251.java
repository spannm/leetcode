package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Problem0251 extends LeetcodeProblem {

    static class Vector2D implements Iterator<Integer> {
        private final Queue<Integer> cache;

        Vector2D(List<List<Integer>> _vec2d) {
            cache = new LinkedList<>();
            if (_vec2d != null && !_vec2d.isEmpty()) {
                for (List<Integer> list : _vec2d) {
                    for (int i : list) {
                        cache.offer(i);
                    }
                }
            }
        }

        @Override
        public Integer next() {
            return cache.poll();
        }

        @Override
        public boolean hasNext() {
            return !cache.isEmpty();
        }
    }

}
