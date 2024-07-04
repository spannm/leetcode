package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.lc0.lc0600.Problem0622.MyCircularQueue;
import org.junit.jupiter.api.Test;

class Problem0622Test extends LeetcodeBaseTest {

    @Test
    void test1() {
        MyCircularQueue obj = new Problem0622.MyCircularQueue(3);
        assertTrue(obj.enQueue(1));
        assertTrue(obj.enQueue(2));
        assertTrue(obj.enQueue(3));
        assertFalse(obj.enQueue(4));
        assertEquals(3, obj.rear());
        assertTrue(obj.isFull());
        assertTrue(obj.deQueue());
        assertTrue(obj.enQueue(4));
        assertEquals(4, obj.rear());
    }

    @Test
    void test2() {
        MyCircularQueue obj = new Problem0622.MyCircularQueue(3);
        assertEquals(-1, obj.rear());
        assertTrue(obj.enQueue(2));
        assertTrue(obj.enQueue(3));
        assertTrue(obj.enQueue(4));
        assertEquals(4, obj.rear());
        assertTrue(obj.isFull());
        assertTrue(obj.deQueue());
        assertTrue(obj.enQueue(4));
    }

}
