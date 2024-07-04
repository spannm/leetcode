package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.lc1.lc1600.Problem1603.ParkingSystem;
import org.junit.jupiter.api.Test;

class Problem1603Test extends LeetcodeBaseTest {

    @Test
    void test() {
        ParkingSystem ps = new ParkingSystem(1, 1, 0);
        assertTrue(ps.addCar(1));
        assertTrue(ps.addCar(2));
        assertFalse(ps.addCar(3));
        assertFalse(ps.addCar(1));
    }

}
