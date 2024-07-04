package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Problem1733 extends LeetcodeProblem {

    int minimumTeachings(int _n, int[][] _languages, int[][] _friendships) {
        Map<Integer, Set<Integer>> langMap = new HashMap<>();
        for (int i = 0; i < _languages.length; i++) {
            Set<Integer> set = new HashSet<>();
            langMap.put(i + 1, set);
            for (int lang : _languages[i]) {
                set.add(lang);
            }
        }
        boolean[] canCommunicate = new boolean[_friendships.length];
        for (int i = 1; i <= _n; i++) {
            for (int j = 0; j < _friendships.length; j++) {
                int friend1 = _friendships[j][0];
                int friend2 = _friendships[j][1];
                if (langMap.get(friend1).contains(i) && langMap.get(friend2).contains(i)) {
                    canCommunicate[j] = true;
                }
            }
        }
        int minTeach = _friendships.length;
        for (int i = 1; i <= _n; i++) {
            Set<Integer> teach = new HashSet<>();
            for (int j = 0; j < _friendships.length; j++) {
                if (!canCommunicate[j]) {
                    int friend1 = _friendships[j][0];
                    int friend2 = _friendships[j][1];
                    if (!langMap.get(friend1).contains(i)) {
                        teach.add(friend1);
                    }
                    if (!langMap.get(friend2).contains(i)) {
                        teach.add(friend2);
                    }
                }
            }
            minTeach = Math.min(minTeach, teach.size());
        }
        return minTeach;
    }

}
