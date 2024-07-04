package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

class Problem0622 extends LeetcodeProblem {

    static class MyCircularQueue {

        private final int   size;
        private final int[] arr;
        private int         rearIndex;
        private int         frontIndex;

        MyCircularQueue(int _size) {
            size = _size;
            arr = new int[_size];
            Arrays.fill(arr, -1);
            rearIndex = 0;
            frontIndex = 0;
        }

        boolean enQueue(int _value) {
            if (arr[rearIndex % size] == -1) {
                arr[rearIndex % size] = _value;
                rearIndex++;
                return true;
            }
            return false;
        }

        boolean deQueue() {
            if (size > 0 && arr[frontIndex % size] != -1) {
                arr[frontIndex % size] = -1;
                frontIndex++;
                return true;
            }
            return false;
        }

        int front() {
            int idx = frontIndex % size;
            return idx < 0 ? -1 : arr[idx];
        }

        int rear() {
            int idx = (rearIndex - 1) % size;
            return idx < 0 ? -1 : arr[idx];
        }

        boolean isEmpty() {
            return rearIndex == frontIndex;
        }

        boolean isFull() {
            return Math.abs(rearIndex - frontIndex) == size;
        }
    }

}
