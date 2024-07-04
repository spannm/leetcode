package io.github.spannm.leetcode.lc0.lc0400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Problem0406 extends LeetcodeProblem {

    int[][] reconstructQueue(int[][] _people) {
        Arrays.sort(_people, (p1, p2) -> p1[0] != p2[0]
            ? Integer.compare(p2[0], p1[0])
            : Integer.compare(p1[1], p2[1]));
        List<int[]> list = new LinkedList<>();
        for (int[] ppl : _people) {
            list.add(ppl[1], ppl);
        }
        return list.toArray(new int[_people.length][]);
    }

}
