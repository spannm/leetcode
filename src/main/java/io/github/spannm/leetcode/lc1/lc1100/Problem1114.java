package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <a href="https://leetcode.com/problems/print-in-order/">1114. Print in Order</a>.
 */
class Problem1114 extends LeetcodeProblem {

    static class Foo {

        private final Queue<Integer> orderQueue = new LinkedBlockingQueue<>();
        private volatile Integer     next;

        Foo() {
            this(1, 2, 3);
        }

        Foo(Integer... _order) {
            if (_order == null || _order.length != 3) {
                throw new IllegalArgumentException("Invalid order: " + Arrays.toString(_order));
            }
            orderQueue.addAll(List.of(_order));
            next = getNext();
        }

        private Integer getNext() {
            Integer n = orderQueue.poll();
            return n;
        }

        public void first() {
            System.out.println("first");
        }

        public void second() {
            System.out.println("second");
        }

        public void third() {
            System.out.println("third");
        }

        public void first(Runnable _printFirst) throws InterruptedException {
            doAction(1, _printFirst);
        }

        public void second(Runnable _printSecond) throws InterruptedException {
            doAction(2, _printSecond);
        }

        public void third(Runnable _printThird) throws InterruptedException {
            doAction(3, _printThird);
        }

        private synchronized void doAction(int _order, Runnable _r) throws InterruptedException {
            while (next != _order) {
                wait();
            }
            _r.run();
            next = getNext();
            notifyAll();
        }

    }

    @SuppressWarnings("PMD.EmptyCatchBlock")
    static void main(String[] _args) throws InterruptedException {
        Foo foo = new Foo(2, 1, 3);
        List<Thread> threads = new ArrayList<>(List.of(
            new Thread(() -> {
                try {
                    foo.first(foo::first);
                } catch (InterruptedException _ex) {
                }
            }, "t1"),
            new Thread(() -> {
                try {
                    foo.second(foo::second);
                } catch (InterruptedException _ex) {
                }
            }, "t2"),
            new Thread(() -> {
                try {
                    foo.third(foo::third);
                } catch (InterruptedException _ex) {
                }
            }, "t3")));
        Collections.shuffle(threads);
        threads.forEach(Thread::start);

        Thread.sleep(500L);

        for (Thread thread : threads) {
            thread.join();
        }
    }

}
