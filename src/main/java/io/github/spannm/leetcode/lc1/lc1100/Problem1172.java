package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem1172 extends LeetcodeProblem {

    static class DinnerPlates {
        private final int                  capacity;
        private final List<Deque<Integer>> stacks  = new ArrayList<>();
        private final TreeSet<Integer>     notFull = new TreeSet<>();

        DinnerPlates(int _capacity) {
            capacity = _capacity;
        }

        void push(int _val) {
            if (notFull.isEmpty()) {
                stacks.add(new ArrayDeque<>());
                stacks.get(stacks.size() - 1).push(_val);
                if (capacity > 1) {
                    notFull.add(stacks.size() - 1);
                }
            } else {
                int index = notFull.first();
                stacks.get(index).push(_val);
                if (stacks.get(index).size() == capacity) {
                    notFull.pollFirst();
                }
            }
        }

        int pop() {
            return popAtStack(stacks.size() - 1);
        }

        int popAtStack(int _index) {
            if (_index < 0 || _index >= stacks.size() || stacks.get(_index).isEmpty()) {
                return -1;
            }
            int val = stacks.get(_index).pop();
            if (_index == stacks.size() - 1 && stacks.get(stacks.size() - 1).isEmpty()) {
                while (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
                    notFull.remove(stacks.size() - 1);
                    stacks.remove(stacks.size() - 1);
                }
            } else {
                notFull.add(_index);
            }
            return val;
        }

    }

}
