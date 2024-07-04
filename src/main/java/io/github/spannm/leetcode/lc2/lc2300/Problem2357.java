package io.github.spannm.leetcode.lc2.lc2300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.TreeSet;

class Problem2357 extends LeetcodeProblem {

    int minimumOperations(int[] _nums) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int num : _nums) {
            if (num > 0) {
                treeSet.add(num);
            }
        }
        int ops = 0;
        while (!treeSet.isEmpty()) {
            int min = treeSet.pollFirst();
            ops++;
            TreeSet<Integer> tmp = new TreeSet<>();
            while (!treeSet.isEmpty()) {
                tmp.add(treeSet.pollFirst() - min);
            }
            treeSet.addAll(tmp);
        }
        return ops;
    }

}
