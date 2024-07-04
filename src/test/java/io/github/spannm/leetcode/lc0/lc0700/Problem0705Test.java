package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeBaseTest;
import io.github.spannm.leetcode.lc0.lc0700.Problem0705.MyHashSet;
import org.junit.jupiter.api.Test;

class Problem0705Test extends LeetcodeBaseTest {

    @Test
    void test1() {
        MyHashSet set = new MyHashSet();
        set.add(1); // set = [1]
        set.add(2); // set = [1, 2]
        assertTrue(set.contains(1));
        assertTrue(set.contains(2));
        assertFalse(set.contains(3));
        set.add(2); // set = [1, 2]
        set.add(2); // set = [1, 2]
        assertTrue(set.contains(1));
        assertTrue(set.contains(2));
        set.remove(2); // set = [1]
        set.remove(2); // set = [1]
        assertTrue(set.contains(1));
        assertFalse(set.contains(2));
        assertEquals("MyHashSet[1]", set.toString());
        set.add(0);
        assertTrue(set.contains(0));
        assertEquals("MyHashSet[0, 1]", set.toString());
    }

    @Test
    void test2() {
        MyHashSet set = new MyHashSet();
        assertFalse(set.contains(72));
        set.remove(91);
        set.add(48);
        set.add(41);
        assertFalse(set.contains(96));
        set.remove(87);
        assertTrue(set.contains(48));
        assertFalse(set.contains(49));
        set.add(84);
        set.add(82);
        set.add(24);
        set.add(7);
        set.remove(56);
        set.add(87);
        set.add(81);
        set.add(55);
        set.add(19);
        set.add(40);
        set.add(68);
        set.add(23);
        set.add(80);
        set.add(53);
        set.add(76);
        assertFalse(set.contains(93));
        set.add(95);
        assertTrue(set.contains(95));
        set.add(67);
        set.add(31);
        assertTrue(set.contains(80));
        set.add(62);
        set.add(73);
        set.remove(97);
        set.add(33);
        set.add(28);
        set.add(62);
        set.add(81);
        set.add(57);
        assertTrue(set.contains(40));
        set.add(11);
        set.add(89);
        set.add(28);
        set.remove(97);
        assertFalse(set.contains(86));
        set.add(20);
        assertFalse(set.contains(5));
        set.add(77);
        set.add(52);
        set.add(57);
        set.add(88);
        set.add(20);
        assertTrue(set.contains(48));
        set.remove(42);
        set.remove(86);
        set.add(49);
        set.remove(62);
        assertTrue(set.contains(53));
        set.add(43);
        set.remove(98);
        set.add(32);
        set.add(15);
        set.add(42);
        set.add(50);
        assertTrue(set.contains(19));
        assertTrue(set.contains(32));
        set.add(67);
        set.remove(84);
        set.remove(60);
        set.remove(8);
        set.remove(85);
        set.add(43);
        set.add(59);
        assertFalse(set.contains(65));
        set.add(40);
        set.add(81);
        set.remove(55);
        set.add(56);
        set.add(54);
        set.add(59);
        set.add(78);
        set.add(53);
        set.add(0);
        set.add(24);
        set.add(7);
        set.remove(53);
        set.add(33);
        set.remove(69);
        set.remove(86);
        set.add(7);
        set.remove(1);
        set.add(16);
        set.remove(58);
        set.add(61);
        set.add(34);
        set.add(53);
        set.remove(84);
        set.remove(21);
        set.remove(58);
        set.add(25);
        assertFalse(set.contains(45));
        set.add(3);
    }

}
