package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Problem0324 extends LeetcodeProblem {

    void wiggleSort(int[] _nums) {
        int median = findKthLargest(_nums, (_nums.length + 1) / 2);
        int len = _nums.length;

        int left = 0;
        int i = 0;
        int right = len - 1;

        while (i <= right) {

            if (_nums[newIndex(i, len)] > median) {
                swap(_nums, newIndex(left++, len), newIndex(i++, len));
            } else if (_nums[newIndex(i, len)] < median) {
                swap(_nums, newIndex(right--, len), newIndex(i, len));
            } else {
                i++;
            }
        }
    }

    static int findKthLargest(int[] _nums, int _k) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.stream(_nums).boxed().forEach(maxHeap::offer);
        while (_k-- > 1) {
            maxHeap.poll();
        }
        return maxHeap.poll();
    }

    static void swap(int[] _nums, int _i, int _j) {
        int tmp = _nums[_i];
        _nums[_i] = _nums[_j];
        _nums[_j] = tmp;
    }

    static int newIndex(int _index, int _n) {
        return (1 + 2 * _index) % (_n | 1);
    }

}
