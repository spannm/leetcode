package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.NestedInteger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Problem0341 extends LeetcodeProblem {

    static class NestedIterator implements Iterator<Integer> {

        private final Queue<Integer> flattenedList;

        NestedIterator(List<NestedInteger> _nestedList) {
            flattenedList = new LinkedList<>();
            constructList(_nestedList);
        }

        private void constructList(List<NestedInteger> _nestedList) {
            for (NestedInteger nestedInteger : _nestedList) {
                if (nestedInteger.isInteger()) {
                    flattenedList.add(nestedInteger.getInteger());
                } else {
                    constructList(nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return flattenedList.poll();
        }

        @Override
        public boolean hasNext() {
            return !flattenedList.isEmpty();
        }
    }

}
