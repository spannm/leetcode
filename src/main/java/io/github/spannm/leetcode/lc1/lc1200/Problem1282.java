package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to">1282. Group the People
 * Given the Group Size They Belong To</a>.
 */
class Problem1282 extends LeetcodeProblem {

    List<List<Integer>> groupThePeople(final int[] _groupSizes) {
        final int nbGroups = _groupSizes.length;
        Map<Integer, List<Integer>> map = new HashMap<>(nbGroups);
        for (int i = 0; i < nbGroups; i++) {
            List<Integer> list = map.getOrDefault(_groupSizes[i], new ArrayList<>());
            list.add(i);
            map.put(_groupSizes[i], list);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            List<Integer> list = entry.getValue();
            int i = 0;
            do {
                result.add(list.subList(i, i + key));
                i += key;
            } while (i + key <= list.size());
        }
        return result;
    }

}
