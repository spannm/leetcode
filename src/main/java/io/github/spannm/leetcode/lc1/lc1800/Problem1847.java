package io.github.spannm.leetcode.lc1.lc1800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * 1847. Closest Room.
 */
class Problem1847 extends LeetcodeProblem {

    int[] closestRoom(int[][] _rooms, int[][] _queries) {
        final int nbRooms = _rooms.length;
        final int nbQueries = _queries.length;
        Arrays.sort(_rooms, Comparator.comparingInt(a -> a[1]));
        Integer[] idx = new Integer[nbQueries];
        for (int i = 0; i < nbQueries; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, Comparator.comparingInt(i -> _queries[i][1]));
        int i = 0;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int[] room : _rooms) {
            tm.merge(room[0], 1, Integer::sum);
        }
        int[] ans = new int[nbQueries];
        Arrays.fill(ans, -1);
        for (int j : idx) {
            int prefer = _queries[j][0];
            int minSize = _queries[j][1];
            while (i < nbRooms && _rooms[i][1] < minSize) {
                if (tm.merge(_rooms[i][0], -1, Integer::sum) == 0) {
                    tm.remove(_rooms[i][0]);
                }
                i++;
            }
            if (i == nbRooms) {
                break;
            }
            Integer p = tm.ceilingKey(prefer);
            if (p != null) {
                ans[j] = p;
            }
            p = tm.floorKey(prefer);
            if (p != null && (ans[j] == -1 || ans[j] - prefer >= prefer - p)) {
                ans[j] = p;
            }
        }
        return ans;
    }

}
