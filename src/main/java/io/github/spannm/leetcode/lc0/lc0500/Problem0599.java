package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 599. Minimum Index Sum of Two Lists.
 */
class Problem0599 extends LeetcodeProblem {

    String[] findRestaurant(String[] _list1, String[] _list2) {
        Map<String, Integer> map = IntStream.range(0, _list2.length).boxed().collect(Collectors.toMap(k -> _list2[k], v -> v));
        List<String> ans = new ArrayList<>();
        int mi = 2000;
        for (int i = 0; i < _list1.length; i++) {
            Integer val = map.get(_list1[i]);
            if (val != null) {
                int t = i + val;
                if (t < mi) {
                    ans = new ArrayList<>();
                    ans.add(_list1[i]);
                    mi = t;
                } else if (t == mi) {
                    ans.add(_list1[i]);
                }
            }
        }
        return ans.toArray(new String[0]);
    }

}
