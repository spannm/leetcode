package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import org.junit.jupiter.api.Test;

class Problem0677Test extends LeetcodeBaseTest {

    @Test
    void test() {
        Problem0677.MapSum mapSum = new Problem0677.MapSum();
        mapSum.insert("apple", 3);
        assertEquals(3, mapSum.sum("ap")); // return 3 (apple = 3)
        mapSum.insert("app", 2);
        assertEquals(5, mapSum.sum("ap")); // return 5 (apple + app = 3 + 2 = 5)
    }

}
