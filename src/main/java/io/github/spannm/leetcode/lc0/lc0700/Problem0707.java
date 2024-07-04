package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.ListNode;

class Problem0707 extends LeetcodeProblem {

    static class MyLinkedList {
        private final ListNode empty = new ListNode();
        private int            count;

        public int get(int _index) {
            if (_index < 0 || _index >= count) {
                return -1;
            }
            ListNode cur = empty.next;
            while (_index-- > 0) {
                cur = cur.next;
            }
            return cur.val;
        }

        public void addAtHead(int _val) {
            addAtIndex(0, _val);
        }

        public void addAtTail(int _val) {
            addAtIndex(count, _val);
        }

        public void addAtIndex(int _index, int _val) {
            if (_index > count) {
                return;
            }
            ListNode pre = empty;
            while (_index-- > 0) {
                pre = pre.next;
            }
            pre.next = new ListNode(_val, pre.next);
            count++;
        }

        public void deleteAtIndex(int _index) {
            if (_index >= 0 && _index < count) {
                ListNode pre = empty;
                while (_index-- > 0) {
                    pre = pre.next;
                }
                ListNode t = pre.next;
                pre.next = t.next;
                t.next = null;
                count--;
            }
        }

    }

}
