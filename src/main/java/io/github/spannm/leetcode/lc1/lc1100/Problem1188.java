package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Semaphore;

class Problem1188 extends LeetcodeProblem {

    static class BoundedBlockingQueue {
        private final Semaphore      s1;
        private final Semaphore      s2;
        private final Deque<Integer> q = new ArrayDeque<>();

        BoundedBlockingQueue(int _capacity) {
            s1 = new Semaphore(_capacity);
            s2 = new Semaphore(0);
        }

        void enqueue(int _element) throws InterruptedException {
            s1.acquire();
            q.offer(_element);
            s2.release();
        }

        int dequeue() throws InterruptedException {
            s2.acquire();
            int ans = q.poll();
            s1.release();
            return ans;
        }

        int size() {
            return q.size();
        }

    }

}
