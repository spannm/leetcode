package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Problem1386 extends LeetcodeProblem {

    int maxNumberOfFamilies(int _n, int[][] _reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] seat : _reservedSeats) {
            if (!map.containsKey(seat[0])) {
                map.put(seat[0], new HashSet<>());
            }
            map.get(seat[0]).add(seat[1]);
        }
        int count = (_n - map.size()) * 2;
        for (int key : map.keySet()) {
            Set<Integer> reservedOnes = map.get(key);
            if (reservedOnes.size() > 6) {
                continue;
            }
            if (!reservedOnes.contains(2) && !reservedOnes.contains(3) && !reservedOnes.contains(4) && !reservedOnes.contains(5) && !reservedOnes.contains(6) && !reservedOnes.contains(7)
                && !reservedOnes.contains(8) && !reservedOnes.contains(9)) {
                count += 2;
            } else if (!reservedOnes.contains(4) && !reservedOnes.contains(5) && !reservedOnes.contains(6) && !reservedOnes.contains(7)) {
                count++;
            } else if (!reservedOnes.contains(2) && !reservedOnes.contains(3) && !reservedOnes.contains(4) && !reservedOnes.contains(5)) {
                count++;
            } else if (!reservedOnes.contains(6) && !reservedOnes.contains(7) && !reservedOnes.contains(8) && !reservedOnes.contains(9)) {
                count++;
            }
        }
        return count;
    }

}
