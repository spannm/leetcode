package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.lc0.lc0700.Problem0703.KthLargest;
import org.junit.jupiter.api.Test;

class Problem0703Test extends LeetcodeBaseTest {

    @Test
    void test() {

        KthLargest kthLargest = new KthLargest(3, new int[] {4, 5, 8, 2});
        assertEquals(4, kthLargest.add(3));
        assertEquals(5, kthLargest.add(5));
        assertEquals(5, kthLargest.add(10));
        assertEquals(8, kthLargest.add(9));
        assertEquals(8, kthLargest.add(4));
    }

}
