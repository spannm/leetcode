package io.github.spannm.leetcode;

import org.junit.jupiter.api.Test;

class LeetcodeProblemTest extends LeetcodeBaseTest {

    @Test
    void test() {
        assertEquals("[1,2,3]", LeetcodeProblem.asString(new int[] {1, 2, 3}));
    }

}
