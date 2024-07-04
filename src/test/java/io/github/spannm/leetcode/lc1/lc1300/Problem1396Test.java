package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.lc1.lc1300.Problem1396.UndergroundSystem;
import org.junit.jupiter.api.Test;

class Problem1396Test extends LeetcodeBaseTest {

    @Test
    void test1() {
        UndergroundSystem us = new UndergroundSystem();

        us.checkIn(45, "Leyton", 3);
        us.checkIn(32, "Paradise", 8);
        us.checkIn(27, "Leyton", 10);
        us.checkOut(45, "Waterloo", 15);
        us.checkOut(27, "Waterloo", 20);
        us.checkOut(32, "Cambridge", 22);
        assertEquals(14.00000, us.getAverageTime("Paradise", "Cambridge"));
        assertEquals(11.00000, us.getAverageTime("Leyton", "Waterloo"));
        us.checkIn(10, "Leyton", 24); //
        assertEquals(11.00000, us.getAverageTime("Leyton", "Waterloo"));
        us.checkOut(10, "Waterloo", 38); //
        assertEquals(12.00000, us.getAverageTime("Leyton", "Waterloo"));

    }

}
