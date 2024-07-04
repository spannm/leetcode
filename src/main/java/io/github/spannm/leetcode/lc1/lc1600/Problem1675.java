package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/minimize-deviation-in-array/">1675. Minimize Deviation in Array</a>.
 */
class Problem1675 extends LeetcodeProblem {

    int minimumDeviation(int[] _nums) {

        if (_nums == null) {
            return 0;
        }
        final int len = _nums.length;
        if (len <= 1) {
            return 0;
        }

        // traverse array and double all odd array elements. This nullifies the requirement for the 2nd operation.
        for (int i = 0; i < len; i++) {
            if (_nums[i] % 2 == 1) { // odd
                _nums[i] *= 2;
            }
        }

        // sorted set (no dups)
        final SortedSet<Integer> set = IntStream.of(_nums).boxed().collect(Collectors.toCollection(TreeSet<Integer>::new));
        int deviation = set.last() - set.first();

        while (set.last() % 2 == 0) { // even
            Integer last = set.last();
            set.remove(last);
            set.add(last / 2);
            deviation = Math.min(deviation, set.last() - set.first());
        }

        return deviation;
    }

}
