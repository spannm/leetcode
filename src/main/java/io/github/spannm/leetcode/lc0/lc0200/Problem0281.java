package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Iterator;
import java.util.List;

class Problem0281 extends LeetcodeProblem {

    static class ZigzagIterator {
        private Iterator<Integer> i;
        private Iterator<Integer> j;

        ZigzagIterator(List<Integer> _v1, List<Integer> _v2) {
            i = _v2.iterator();
            j = _v1.iterator();
        }

        int next() {
            if (j.hasNext()) {
                Iterator<Integer> tmp = j;
                j = i;
                i = tmp;
            }
            return i.next();
        }

        boolean hasNext() {
            return i.hasNext() || j.hasNext();
        }
    }

}
