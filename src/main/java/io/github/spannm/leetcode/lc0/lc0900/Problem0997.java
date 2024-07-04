package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem0997 extends LeetcodeProblem {

    int findJudge(int _n, int[][] _trust) {
        int[] trustPoints = new int[_n];
        Set<Integer> trustOthers = new HashSet<>();
        for (int[] eachTrust : _trust) {
            trustPoints[eachTrust[1] - 1]++;
            trustOthers.add(eachTrust[0]);
        }
        int judge = -1;
        for (int i = 0; i < trustPoints.length; i++) {
            if (trustPoints[i] == _n - 1 && !trustOthers.contains(i + 1)) {
                judge = i + 1;
            }
        }
        return judge;
    }

}
