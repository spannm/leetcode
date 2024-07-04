package io.github.spannm.leetcode.lc3.lc3000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * 3072. Distribute Elements Into Two Arrays II.
 */
class Problem3072 extends LeetcodeProblem {

    int[] resultArray(int[] _nums) {
        int[] st = _nums.clone();
        Arrays.sort(st);
        int len = st.length;
        BinaryIndexedTree tree1 = new BinaryIndexedTree(len + 1);
        BinaryIndexedTree tree2 = new BinaryIndexedTree(len + 1);
        tree1.update(Arrays.binarySearch(st, _nums[0]) + 1, 1);
        tree2.update(Arrays.binarySearch(st, _nums[1]) + 1, 1);
        int[] arr1 = new int[len];
        int[] arr2 = new int[len];
        arr1[0] = _nums[0];
        arr2[0] = _nums[1];
        int i = 1;
        int j = 1;
        for (int k = 2; k < len; ++k) {
            int x = Arrays.binarySearch(st, _nums[k]) + 1;
            int a = i - tree1.query(x);
            int b = j - tree2.query(x);
            if (a > b) {
                arr1[i++] = _nums[k];
                tree1.update(x, 1);
            } else if (a < b) {
                arr2[j++] = _nums[k];
                tree2.update(x, 1);
            } else if (i <= j) {
                arr1[i++] = _nums[k];
                tree1.update(x, 1);
            } else {
                arr2[j++] = _nums[k];
                tree2.update(x, 1);
            }
        }
        for (int k = 0; k < j; ++k) {
            arr1[i++] = arr2[k];
        }
        return arr1;
    }

    static class BinaryIndexedTree {
        private final int n;
        private final int[] c;

        BinaryIndexedTree(int _n) {
            n = _n;
            c = new int[_n + 1];
        }

        void update(int _x, int _delta) {
            for (; _x <= n; _x += _x & -_x) {
                c[_x] += _delta;
            }
        }

        int query(int _x) {
            int s = 0;
            for (; _x > 0; _x -= _x & -_x) {
                s += c[_x];
            }
            return s;
        }

    }

}
