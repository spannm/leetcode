package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem1670 extends LeetcodeProblem {

    static class FrontMiddleBackQueue {
        private final List<Integer> list;

        FrontMiddleBackQueue() {
            list = new ArrayList<>();
        }

        void pushFront(int _val) {
            list.add(0, _val);
        }

        void pushMiddle(int _val) {
            list.add(list.size() / 2, _val);
        }

        void pushBack(int _val) {
            list.add(_val);
        }

        int popFront() {
            if (!list.isEmpty()) {
                return list.remove(0);
            }
            return -1;
        }

        int popMiddle() {
            if (!list.isEmpty()) {
                return list.remove(list.size() % 2 == 0 ? list.size() / 2 - 1 : list.size() / 2);
            }
            return -1;
        }

        int popBack() {
            if (!list.isEmpty()) {
                return list.remove(list.size() - 1);
            }
            return -1;
        }
    }

}
