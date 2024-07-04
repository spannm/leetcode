package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * 857. Minimum Cost to Hire K Workers.
 */
class Problem0857 extends LeetcodeProblem {

    double mincostToHireWorkers(int[] _quality, int[] _wage, int _k) {
        Worker[] workers = IntStream.range(0, _quality.length)
            .mapToObj(i -> new Worker(_quality[i], _wage[i]))
            .sorted(Comparator.comparingDouble(w -> w.wagePerQ))
            .toArray(Worker[]::new);
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        double amt = 1e9;
        int tot = 0;
        for (var w : workers) {
            tot += w.quality;
            pq.offer(w.quality);
            if (pq.size() == _k) {
                amt = Math.min(amt, tot * w.wagePerQ);
                tot -= pq.poll();
            }
        }
        return amt;
    }

    static class Worker {
        private final int    quality;  // quality
        private final double wagePerQ; // wage per quality

        Worker(int _q, int _w) {
            quality = _q;
            wagePerQ = (double) _w / _q;
        }

    }

}
