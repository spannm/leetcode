package io.github.spannm.leetcode.lc0.lc0100;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/insertion-sort-list/">147. Insertion Sort List</a>.
 */
class Problem0147 extends LeetcodeProblem {

    ListNode insertionSortList(ListNode _head) {
        ListNode temp = _head;
        List<Integer> list = new ArrayList<>();
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        Integer[] nums = list.toArray(new Integer[0]);
        for (int i = 1; i < list.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[j + 1]) {
                    int tempNum = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tempNum;
                }
            }
        }
        ListNode newHead = _head;
        for (Integer num : nums) {
            newHead.val = num;
            newHead = newHead.next;
        }
        return _head;
    }

}
