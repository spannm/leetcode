package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Stack;

class Problem1265 extends LeetcodeProblem {

    interface IImmutableListNode {
        IImmutableListNode getNext();

        void printValue();
    }

    void printLinkedListInReverse(IImmutableListNode _head) {
        Stack<IImmutableListNode> stack = new Stack<>();
        while (_head != null) {
            stack.add(_head);
            _head = _head.getNext();
        }
        while (!stack.isEmpty()) {
            _head = stack.pop();
            _head.printValue();
        }
    }

}
