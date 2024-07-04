package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

import java.util.Random;

/**
 * <a href="https://leetcode.com/problems/linked-list-random-node/">382. Linked List Random Node</a>.
 */
class Problem0382 extends LeetcodeProblem {

    static class Solution {
        private final ListNode head;
        private final Random   rand;

        Solution(ListNode _head) {
            head = _head;
            rand = new Random();
        }

        public int getRandom() {
            int count = 0;
            int result = 0;
            ListNode curr = head;

            while (curr != null) {
                count++;
                // generate a random number between 1 and the count
                // if the random number is 1, update the result with the current node's value
                if (rand.nextInt(count) == 0) {
                    result = curr.val;
                }
                curr = curr.next;
            }

            return result;
        }
    }

}
