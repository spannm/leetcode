package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

class Problem0284 extends LeetcodeProblem {

    static class PeekingIterator implements Iterator<Integer> {

        private final Queue<Integer> q;

        PeekingIterator(Iterator<Integer> _iter) {
            q = StreamSupport.stream(((Iterable<Integer>) () -> _iter).spliterator(), false).collect(Collectors.toCollection(LinkedList::new));
        }

        Integer peek() {
            return q.peek();
        }

        @Override
        public Integer next() {
            return q.poll();
        }

        @Override
        public boolean hasNext() {
            return !q.isEmpty();
        }
    }

}
