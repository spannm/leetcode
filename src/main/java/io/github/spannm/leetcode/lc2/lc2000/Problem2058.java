package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

import java.util.ArrayList;
import java.util.List;

class Problem2058 extends LeetcodeProblem {

    int[] nodesBetweenCriticalPoints(ListNode _head) {
        List<Integer> list = new ArrayList<>();
        while (_head != null) {
            list.add(_head.val);
            _head = _head.next;
        }
        List<Integer> criticalPts = new ArrayList<>();
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i - 1) && list.get(i) > list.get(i + 1)) {
                criticalPts.add(i);
            } else if (list.get(i) < list.get(i - 1) && list.get(i) < list.get(i + 1)) {
                criticalPts.add(i);
            }
        }
        if (criticalPts.size() < 2) {
            return new int[] {-1, -1};
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < criticalPts.size() - 1; i++) {
            min = Math.min(min, criticalPts.get(i + 1) - criticalPts.get(i));
        }
        int size = criticalPts.size();
        return new int[] {min, criticalPts.get(size - 1) - criticalPts.get(0)};
    }

}
