package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * 786. K-th Smallest Prime Fraction.
 */
class Problem0786 extends LeetcodeProblem {

    int[] kthSmallestPrimeFraction(int[] _arr, int _k) {
        Queue<Fraction> pq = new PriorityQueue<>();
        IntStream.range(1, _arr.length).forEach(i -> pq.offer(new Fraction(1, _arr[i], 0, i)));
        for (int i = 1; i < _k; i++) {
            Fraction polled = pq.poll();
            if (polled.i + 1 < polled.j) {
                pq.offer(new Fraction(_arr[polled.i + 1], _arr[polled.j], polled.i + 1, polled.j));
            }
        }
        Fraction kth = pq.peek();
        return new int[] {kth.x, kth.y};
    }

    static class Fraction implements Comparable<Fraction> {
        private final int x;
        private final int y;
        private final int i;
        private final int j;

        Fraction(int _x, int _y, int _i, int _j) {
            x = _x;
            y = _y;
            i = _i;
            j = _j;
        }

        @Override
        public int compareTo(Fraction _o) {
            return x * _o.y - _o.x * y;
        }
    }

}
