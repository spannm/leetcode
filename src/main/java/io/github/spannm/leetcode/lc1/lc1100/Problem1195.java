package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class Problem1195 extends LeetcodeProblem {

    static class FizzBuzz {
        private final int       n;

        private final Semaphore fSema  = new Semaphore(0);
        private final Semaphore bSema  = new Semaphore(0);
        private final Semaphore fbSema = new Semaphore(0);
        private final Semaphore nSema  = new Semaphore(1);

        FizzBuzz(int _n) {
            n = _n;
        }

        void fizz(Runnable _printFizz) throws InterruptedException {
            for (int i = 3; i <= n; i = i + 3) {
                if (i % 5 != 0) {
                    fSema.acquire();
                    _printFizz.run();
                    nSema.release();
                }
            }
        }

        void buzz(Runnable _printBuzz) throws InterruptedException {
            for (int i = 5; i <= n; i = i + 5) {
                if (i % 3 != 0) {
                    bSema.acquire();
                    _printBuzz.run();
                    nSema.release();
                }
            }
        }

        void fizzbuzz(Runnable _printFizzBuzz) throws InterruptedException {
            for (int i = 15; i <= n; i = i + 15) {
                fbSema.acquire();
                _printFizzBuzz.run();
                nSema.release();
            }
        }

        void number(IntConsumer _printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                nSema.acquire();
                if (i % 3 == 0 && i % 5 == 0) {
                    fbSema.release();
                } else if (i % 3 == 0) {
                    fSema.release();
                } else if (i % 5 == 0) {
                    bSema.release();
                } else {
                    _printNumber.accept(i);
                    nSema.release();
                }
            }
        }

    }

}
