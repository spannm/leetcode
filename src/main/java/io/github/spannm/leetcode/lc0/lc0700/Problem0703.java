package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-a-stream/">703. Kth Largest Element in a Stream</a>.
 */
class Problem0703 extends LeetcodeProblem {

    static class KthLargest {
        private final int           k;
        private final List<Integer> list;

        KthLargest(int _k, int[] _nums) {
            k = _k;
            list = new ArrayList<>();
            list.addAll(IntStream.of(_nums).boxed().toList());
            Collections.sort(list);
        }

        public int add(int _val) {
            list.add(_val);
            Collections.sort(list);
            return list.get(list.size() - k);
        }
    }

}
