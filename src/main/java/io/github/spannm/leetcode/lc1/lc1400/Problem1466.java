package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/"> 1466. Reorder Routes
 * to Make All Paths Lead to the City Zero</a>.
 */
class Problem1466 extends LeetcodeProblem {

    int minReorder(int _n, int[][] _connections) {
        List<List<Integer>> cityConns = new ArrayList<>();
        for (int i = 0; i < _n; i++) {
            cityConns.add(new ArrayList<>());
        }
        for (int[] conn : _connections) {
            cityConns.get(conn[0]).add(conn[1]);
            cityConns.get(conn[1]).add(-conn[0]);
        }
        return depthFirstSearch(cityConns, new boolean[_n], 0);
    }

    static int depthFirstSearch(List<List<Integer>> _cityConns, boolean[] _citiesVisited, int _fromCity) {
        int change = 0;
        _citiesVisited[_fromCity] = true;
        for (int to : _cityConns.get(_fromCity)) {
            if (!_citiesVisited[Math.abs(to)]) {
                change += depthFirstSearch(_cityConns, _citiesVisited, Math.abs(to)) + (to > 0 ? 1 : 0);
            }
        }
        return change;
    }

}
