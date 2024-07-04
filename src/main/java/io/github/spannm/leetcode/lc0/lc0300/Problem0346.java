package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Deque;
import java.util.LinkedList;

class Problem0346 extends LeetcodeProblem {

    static class MovingAverage {

        private final Deque<Integer> q;
        private Long                 sum;
        private final int            max;

        MovingAverage(int _size) {
            q = new LinkedList<>();
            sum = 0L;
            max = _size;
        }

        public double next(int _val) {
            if (q.size() >= max) {
                int first = q.pollFirst();
                sum -= first;
            }
            q.offer(_val);
            sum += _val;
            return (double) sum / q.size();
        }
    }

}
