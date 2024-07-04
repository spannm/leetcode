package io.github.spannm.leetcode.dep;

import java.util.Objects;

@SuppressWarnings("checkstyle:VisibilityModifierCheck")
public class ListNode {
    public int      val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int _val) {
        this(_val, null);
    }

    public ListNode(int _val, ListNode _next) {
        val = _val;
        next = _next;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    @Override
    public boolean equals(Object _obj) {
        if (this == _obj) {
            return true;
        } else if (_obj == null || getClass() != _obj.getClass()) {
            return false;
        }
        ListNode other = (ListNode) _obj;
        return val == other.val && Objects.equals(next, other.next);
    }

    @Override
    public String toString() {
        ListNode node = this;
        StringBuilder sb = new StringBuilder()
            .append("[")
            .append(val)
            .append("]");
        while ((node = node.next) != null) {
            sb.append(",").append("[").append(node.val).append("]");

        }
        return sb.toString();
    }

    public static ListNode fromBigDecimal(java.math.BigDecimal _sum) {
        return fromCharArray(String.valueOf(_sum).toCharArray());
    }

    public static ListNode fromCharArray(char[] _digits) {
        ListNode prev = null;
        for (char d : _digits) {
            int digit = d - '0';
            prev = new ListNode(digit, prev);
        }
        return prev;
    }

    public static java.math.BigDecimal toBigDecimal(ListNode _ln, boolean _reverse) {
        StringBuilder sb = new StringBuilder();
        ListNode node = _ln;
        while (node != null) {
            sb.append(node.val);
            node = node.next;
        }
        String str = (_reverse ? sb.reverse() : sb).toString();
        return new java.math.BigDecimal(str);
    }

    public static ListNode createLinkedList(int... _nums) {
        ListNode node = null;
        for (int i = _nums.length - 1; i >= 0; i--) {
            node = new ListNode(_nums[i], node);
        }
        return node;
    }

}
