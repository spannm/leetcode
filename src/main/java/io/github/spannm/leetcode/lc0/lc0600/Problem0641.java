package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0641 extends LeetcodeProblem {

    static class MyCircularDeque {
        private final int[] q;
        private int         front;
        private int         size;
        private final int   capacity;

        MyCircularDeque(int _k) {
            q = new int[_k];
            capacity = _k;
        }

        boolean insertFront(int _value) {
            if (isFull()) {
                return false;
            } else if (!isEmpty()) {
                front = (front - 1 + capacity) % capacity;
            }
            q[front] = _value;
            size++;
            return true;
        }

        boolean insertLast(int _value) {
            if (isFull()) {
                return false;
            }
            int idx = (front + size) % capacity;
            q[idx] = _value;
            size++;
            return true;
        }

        boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            front = (front + 1) % capacity;
            size--;
            return true;
        }

        boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            size--;
            return true;
        }

        int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return q[front];
        }

        int getRear() {
            if (isEmpty()) {
                return -1;
            }
            int idx = (front + size - 1) % capacity;
            return q[idx];
        }

        boolean isEmpty() {
            return size == 0;
        }

        boolean isFull() {
            return size == capacity;
        }

    }

}
