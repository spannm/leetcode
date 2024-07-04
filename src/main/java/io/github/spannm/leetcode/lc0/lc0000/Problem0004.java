package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/">4. Median of Two Sorted Arrays</a>.
 */
class Problem0004 extends LeetcodeProblem {

    double findMedianSortedArrays(int[] _nums1, int[] _nums2) {
        LinkedList<Integer> l1 = Arrays.stream(_nums1).boxed().collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Integer> l2 = Arrays.stream(_nums2).boxed().collect(Collectors.toCollection(LinkedList::new));

        // merge sorted arrays into one
        final LinkedList<Integer> merged = new LinkedList<>();
        while (!l1.isEmpty() && !l2.isEmpty()) {
            if (l1.getFirst() <= l2.getFirst()) {
                merged.addLast(l1.removeFirst());
            } else {
                merged.addLast(l2.removeFirst());
            }
        }
        merged.addAll(l1);
        merged.addAll(l2);

        double median = merged.get(merged.size() / 2);
        if (merged.size() % 2 == 0) {
            median = (median + merged.get(merged.size() / 2 - 1)) / 2;
        }
        return median;
    }

    List<Integer> merge(LinkedList<Integer> _l1, LinkedList<Integer> _l2) {
        LinkedList<Integer> merged = new LinkedList<>();
        while (!_l1.isEmpty() && !_l2.isEmpty()) {
            if (_l1.getFirst() <= _l2.getFirst()) {
                merged.addLast(_l1.removeFirst());
            } else {
                merged.addLast(_l2.removeFirst());
            }
        }
        merged.addAll(_l1);
        merged.addAll(_l2);
        return merged;
    }

}
