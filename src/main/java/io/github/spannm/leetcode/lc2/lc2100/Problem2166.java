package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem2166 extends LeetcodeProblem {
    static class Bitset {

        private final int   size;
        private int         ones;
        private final int[] nums1;
        private final int[] nums2;
        private boolean     checkingNums1;

        Bitset(int _size) {
            nums1 = new int[_size];
            nums2 = new int[_size];
            for (int i = 0; i < _size; i++) {
                nums2[i] = 1;
            }
            ones = 0;
            size = _size;
            checkingNums1 = true;
        }

        public void fix(int _idx) {
            if (checkingNums1) {
                if (nums1[_idx] == 0) {
                    ones++;
                }
                nums1[_idx] = 1;
                nums2[_idx] = 0;
            } else {
                if (nums2[_idx] == 0) {
                    ones++;
                }
                nums2[_idx] = 1;
                nums1[_idx] = 0;
            }
        }

        public void unfix(int _idx) {
            if (checkingNums1) {
                if (nums1[_idx] == 1) {
                    ones--;
                }
                nums1[_idx] = 0;
                nums2[_idx] = 1;
            } else {
                if (nums2[_idx] == 1) {
                    ones--;
                }
                nums2[_idx] = 0;
                nums1[_idx] = 1;
            }
        }

        public void flip() {
            ones = size - ones;
            checkingNums1 = !checkingNums1;
        }

        public boolean all() {
            return ones == size;
        }

        public boolean one() {
            return ones > 0;
        }

        public int count() {
            return ones;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (checkingNums1) {
                for (int i = 0; i < size; i++) {
                    sb.append(nums1[i]);
                }
            } else {
                for (int i = 0; i < size; i++) {
                    sb.append(nums2[i]);
                }
            }
            return sb.toString();
        }
    }

}
