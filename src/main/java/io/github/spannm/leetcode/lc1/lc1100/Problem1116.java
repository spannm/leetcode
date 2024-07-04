package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class Problem1116 extends LeetcodeProblem {

    static class ZeroEvenOdd {
        private final int       n;
        private final Semaphore z = new Semaphore(1);
        private final Semaphore e = new Semaphore(0);
        private final Semaphore o = new Semaphore(0);

        ZeroEvenOdd(int _n) {
            n = _n;
        }

        void zero(IntConsumer _printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                z.acquire(1);
                _printNumber.accept(0);
                if (i % 2 == 0) {
                    o.release(1);
                } else {
                    e.release(1);
                }
            }
        }

        void even(IntConsumer _printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                e.acquire(1);
                _printNumber.accept(i);
                z.release(1);
            }
        }

        void odd(IntConsumer _printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                o.acquire(1);
                _printNumber.accept(i);
                z.release(1);
            }
        }

    }

}
