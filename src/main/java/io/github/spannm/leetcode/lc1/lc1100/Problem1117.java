package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * <a href="https://leetcode.com/problems/building-h2o/">1117. Building H2O</a>.
 */
@SuppressWarnings("PMD.EmptyCatchBlock")
class Problem1117 extends LeetcodeProblem {

    private final CyclicBarrier barrier = new CyclicBarrier(3);
    private final Semaphore     hSem    = new Semaphore(2);
    private final Semaphore     oSem    = new Semaphore(1);

    void hydrogen(Runnable _releaseHydrogen) {
        try {
            hSem.acquire();
            barrier.await();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            _releaseHydrogen.run();
        } catch (Exception _ex) {
        } finally {
            hSem.release();
        }

    }

    void oxygen(Runnable _releaseOxygen) {
        try {
            oSem.acquire();
            barrier.await();
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            _releaseOxygen.run();
        } catch (Exception _ex) {
        } finally {
            oSem.release();
        }
    }

}
