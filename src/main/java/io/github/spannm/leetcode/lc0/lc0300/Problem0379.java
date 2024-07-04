package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Problem0379 extends LeetcodeProblem {

    static class PhoneDirectory {
        private final Queue<Integer> phoneDir;
        private final Set<Integer>   used;

        PhoneDirectory(int _maxNumbers) {
            phoneDir = new LinkedList<>();
            int number = 0;
            while (_maxNumbers-- > 0) {
                phoneDir.add(number++);
            }
            used = new HashSet<>();
        }

        public int get() {
            if (phoneDir.peek() == null) {
                return -1;
            }
            int newNumber = phoneDir.poll();
            used.add(newNumber);
            return newNumber;
        }

        public boolean check(int _number) {
            return !used.contains(_number);
        }

        public void release(int _number) {
            if (used.remove(_number)) {
                phoneDir.add(_number);
            }
        }
    }

}
