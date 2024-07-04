package io.github.spannm.leetcode.lc0.lc0000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/two-sum/">1. Two Sum</a>.
 */
class Problem0001 extends LeetcodeProblem {

    int[] twoSum(int[] _nums, int _target) {
        List<IdxAndNum> idxAndNums = new ArrayList<>();
        for (int i = 0; i < _nums.length; i++) {
            idxAndNums.add(new IdxAndNum(i, _nums[i]));
        }
        idxAndNums.sort(java.util.Comparator.comparing(IdxAndNum::getNum).thenComparing(IdxAndNum::getIdx));

        final int len = idxAndNums.size();

        int[] result = null;

        for (int i1 = 0; i1 < len - 1; i1++) {
            IdxAndNum in1 = idxAndNums.get(i1);
            for (int i2 = i1 + 1; i2 < len; i2++) {
                IdxAndNum in2 = idxAndNums.get(i2);
                if ((result = calcSum(in1, in2, _target)) != null) {
                    return result;
                }
            }

        }

        return null;
    }

    /**
     * Calculates the sum of two values.<br>
     * If equal to {@code target}, returns their indices in an int array.
     */
    static int[] calcSum(IdxAndNum _in1, IdxAndNum _in2, int _target) {
        if (_in1.getNum() + _in2.getNum() == _target) {
            return new int[] {_in1.getIdx(), _in2.getIdx()};
        }
        return null;
    }

    static final class IdxAndNum {
        private final int idx;
        private final int num;

        IdxAndNum(int _idx, int _num) {
            idx = _idx;
            num = _num;
        }

        int getIdx() {
            return idx;
        }

        int getNum() {
            return num;
        }

        @Override
        public String toString() {
            return String.format("%s[idx=%s, num=%s]", getClass().getSimpleName(), idx, num);
        }
    }

}
