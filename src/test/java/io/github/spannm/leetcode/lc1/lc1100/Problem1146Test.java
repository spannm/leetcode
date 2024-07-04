package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.lc1.lc1100.Problem1146.SnapshotArray;
import org.junit.jupiter.api.Test;

class Problem1146Test extends LeetcodeBaseTest {

    @Test
    void test1() {
        SnapshotArray arr = new SnapshotArray(3);
        arr.set(0, 5);
        assertEquals(0, arr.snap());
        arr.set(0, 6);
        assertEquals(5, arr.get(0, 0));
    }

    @Test
    void testcase25() {
        SnapshotArray arr = new SnapshotArray(4);
        assertEquals(0, arr.snap());
        assertEquals(1, arr.snap());
        assertEquals(0, arr.get(3, 1));
        arr.set(2, 4);
        assertEquals(2, arr.snap());
        arr.set(1, 4);
    }

    @Test
    void testcase41() {
        SnapshotArray arr = new SnapshotArray(1);
        arr.set(0, 15);
        assertEquals(0, arr.snap());
        assertEquals(1, arr.snap());
        assertEquals(2, arr.snap());
        assertEquals(15, arr.get(0, 2));
        assertEquals(3, arr.snap());
        assertEquals(4, arr.snap());
        assertEquals(15, arr.get(0, 0));
    }

}
