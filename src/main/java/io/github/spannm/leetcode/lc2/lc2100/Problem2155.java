package io.github.spannm.leetcode.lc2.lc2100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class Problem2155 extends LeetcodeProblem {

    List<Integer> maxScoreIndices(int[] _nums) {
        TreeMap<Integer, List<Integer>> tmap = new TreeMap<>();
        int ones = 0;
        for (int num : _nums) {
            ones += num;
        }
        int zeroes = 0;
        List<Integer> l = new ArrayList<>();
        l.add(0);
        tmap.put(ones, l);
        for (int i = 0; i < _nums.length; i++) {
            if (_nums[i] == 0) {
                zeroes++;
            } else {
                ones--;
            }
            int score = ones + zeroes;
            List<Integer> list = tmap.getOrDefault(score, new ArrayList<>());
            Integer index = i + 1;
            list.add(index);
            tmap.put(score, list);
        }
        return tmap.lastEntry().getValue();
    }

}
