package io.github.spannm.leetcode.lc0.lc0700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/design-hashset/">705. Design HashSet</a>.
 */
class Problem0705 extends LeetcodeProblem {

    static class MyHashSet {

        private int      entryCount;
        private int      capacity;
        private Object[] arr;

        MyHashSet() {
            this(5);
        }

        MyHashSet(int _capacity) {
            entryCount = 0;
            capacity = _capacity;
            arr = new Object[capacity];
        }

        void add(int _key) {
            if (contains(_key)) {
                return;
            }
            entryCount++;
            if (entryCount > capacity) {
                capacity += 5;
                arr = Arrays.copyOf(arr, capacity);
            }
            arr[entryCount - 1] = _key;
            Arrays.sort(arr, 0, entryCount);
        }

        void remove(int _key) {
            int found = Arrays.binarySearch(arr, 0, entryCount, _key);
            if (found > -1) {
                entryCount--;
                if (entryCount - found >= 0) {
                    System.arraycopy(arr, found + 1, arr, found, entryCount - found);
                }
                arr[entryCount] = null;
            }
        }

        boolean contains(int _key) {
            return Arrays.binarySearch(arr, 0, entryCount, _key) > -1;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < entryCount; i++) {
                sb.append(arr[i]);
                if (i < entryCount - 1) {
                    sb.append(", ");
                }
            }
            sb.append(']');
            return getClass().getSimpleName() + sb;
        }
    }

}
