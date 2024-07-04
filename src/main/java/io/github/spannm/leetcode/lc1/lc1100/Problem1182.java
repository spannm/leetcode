package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Problem1182 extends LeetcodeProblem {

    List<Integer> shortestDistanceColor(int[] _colors, int[][] _queries) {
        Map<Integer, List<Integer>> map = buildMap(_colors);
        List<Integer> result = new ArrayList<>();
        for (int[] query : _queries) {
            result.add(binarySearch(query[0], map.get(query[1])));
        }
        return result;
    }

    private Integer binarySearch(int _index, List<Integer> _indices) {
        if (_indices == null) {
            return -1;
        }
        int left = 0;
        int right = _indices.size() - 1;
        int minDistance = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (_indices.get(mid) == _index) {
                return 0;
            } else if (_indices.get(mid) > _index) {
                minDistance = Math.min(minDistance, _indices.get(mid) - _index);
                right = mid - 1;
            } else {
                minDistance = Math.min(minDistance, _index - _indices.get(mid));
                left = mid + 1;
            }
        }
        return minDistance;
    }

    private Map<Integer, List<Integer>> buildMap(int[] _colors) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < _colors.length; i++) {
            if (!map.containsKey(_colors[i])) {
                map.put(_colors[i], new ArrayList<>());
            }
            map.get(_colors[i]).add(i);
        }
        return map;
    }

}
