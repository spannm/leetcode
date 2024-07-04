package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1845 extends LeetcodeProblem {
    static class SeatManager {
        private final boolean[] seats;
        private int             next;

        SeatManager(int _n) {
            seats = new boolean[_n + 1];
            next = 1;
        }

        public int reserve() {
            seats[next] = true;
            int tmp = next;
            while (next < seats.length && seats[next]) {
                next++;
            }
            return tmp;
        }

        public void unreserve(int _seatNumber) {
            seats[_seatNumber] = false;
            if (next > _seatNumber) {
                next = _seatNumber;
            }
        }
    }

}
