package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1570 extends LeetcodeProblem {
    static class SparseVector {
        private final int[] vector;

        SparseVector(int[] _nums) {
            vector = _nums;
        }

        public int dotProduct(SparseVector _vec) {
            int[] incoming = _vec.vector;
            int dotProduct = 0;
            for (int i = 0; i < vector.length; i++) {
                dotProduct += incoming[i] * vector[i];
            }
            return dotProduct;
        }
    }

}
