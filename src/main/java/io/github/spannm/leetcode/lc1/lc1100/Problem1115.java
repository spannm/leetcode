package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * <a href="https://leetcode.com/problems/print-foobar-alternately/">1115. Print FooBar Alternately</a>.
 */
class Problem1115 extends LeetcodeProblem {

    static class FooBar {
        private final int        n;
        private volatile boolean bar = false;

        FooBar(int _n) {
            n = _n;
        }

        public void foo(Runnable _printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (this) {
                    if (bar) {
                        wait();
                    }

                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    _printFoo.run();
                    bar = true;
                    notify();
                }
            }
        }

        public void bar(Runnable _printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized (this) {
                    if (!bar) {
                        wait();
                    }

                    // printBar.run() outputs "bar". Do not change or remove this line.
                    _printBar.run();
                    bar = false;
                    notify();
                }
            }
        }

        @SuppressWarnings("PMD.EmptyCatchBlock")
        public static void main(String[] _args) {
            FooBar fooBar = new FooBar(1);
            Thread ft = new Thread(() -> {
                try {
                    fooBar.foo(() -> System.out.print("foo"));
                } catch (InterruptedException _ex) {
                }
            }, "fooThread");
            Thread bt = new Thread(() -> {
                try {
                    fooBar.bar(() -> System.out.print("bar"));
                } catch (InterruptedException _ex) {
                }
            }, "barThread");
            ft.start();
            bt.start();
        }

    }

}
