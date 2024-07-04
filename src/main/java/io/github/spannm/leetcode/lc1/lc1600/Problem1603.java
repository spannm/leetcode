package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/design-parking-system/">1603. Design Parking System</a>.
 */
class Problem1603 extends LeetcodeProblem {

    static class ParkingSystem {
        private final int[] slots;

        ParkingSystem(int _big, int _medium, int _small) {
            slots = new int[] {_big, _medium, _small};
        }

        public boolean addCar(int _carType) {
            return slots[_carType - 1]-- > 0;
        }
    }

    static class ParkingSystem2 {
        private static final int            TYPE_BIG   = 1;
        private static final int            TYPE_MED   = 2;
        private static final int            TYPE_SMALL = 3;

        private final Map<Integer, Integer> slots      = new LinkedHashMap<>();

        ParkingSystem2(int _big, int _medium, int _small) {
            slots.put(TYPE_BIG, _big);
            slots.put(TYPE_MED, _medium);
            slots.put(TYPE_SMALL, _small);
        }

        public boolean addCar(int _carType) {
            return slots.containsKey(_carType) && slots.compute(_carType, (k, v) -> --v) > -1;
        }
    }

}
