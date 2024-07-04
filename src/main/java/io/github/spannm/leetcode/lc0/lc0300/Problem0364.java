package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.NestedInteger;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Problem0364 extends LeetcodeProblem {

    int depthSumInverse(List<NestedInteger> _nestedList) {
        Queue<NestedInteger> q = new LinkedList<>();
        for (NestedInteger next : _nestedList) {
            q.offer(next);
        }
        int prev = 0;
        int total = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                NestedInteger next = q.poll();
                if (next.isInteger()) {
                    levelSum += next.getInteger();
                } else {
                    List<NestedInteger> list = next.getList();
                    for (NestedInteger n : list) {
                        q.offer(n);
                    }
                }
            }
            prev += levelSum;
            total += prev;
        }
        return total;
    }

}
