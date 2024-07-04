package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Problem0554 extends LeetcodeProblem {

    int leastBricks(List<List<Integer>> _wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : _wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                Integer brick = row.get(i);
                sum += brick;
                map.compute(sum, (k, v) -> v == null ? 1 : v + 1);
            }
        }
        int result = _wall.size();
        for (int key : map.keySet()) {
            result = Math.min(result, _wall.size() - map.get(key));
        }
        return result;
    }

}
