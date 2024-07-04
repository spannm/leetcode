package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem1452 extends LeetcodeProblem {

    List<Integer> peopleIndexes(List<List<String>> _favoriteCompanies) {
        Map<String, Integer> map = new TreeMap<>(Comparator.comparingInt(String::length).thenComparing(o -> o));
        Map<String, Set<String>> setMap = new HashMap<>();
        for (int i = 0; i < _favoriteCompanies.size(); i++) {
            List<String> list = _favoriteCompanies.get(i);
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            Set<String> set = new HashSet<>();
            for (String str : list) {
                sb.append(str);
                set.add(str);
            }
            map.put(sb.toString(), i);
            setMap.put(sb.toString(), set);
        }
        List<String> keys = new ArrayList<>(map.keySet());
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < keys.size(); i++) {
            boolean goodCandidate = true;
            for (int j = i + 1; j < keys.size(); j++) {
                if (keys.get(j).contains(keys.get(i))) {
                    goodCandidate = false;
                    break;
                }
            }
            if (goodCandidate) {
                Set<String> smallerSet = setMap.get(keys.get(i));
                for (int j = 0; j < keys.size(); j++) {
                    if (j != i) {
                        Set<String> biggerSet = setMap.get(keys.get(j));
                        if (biggerSet.containsAll(smallerSet)) {
                            goodCandidate = false;
                            break;
                        }
                    }
                }
            }
            if (goodCandidate) {
                result.add(map.get(keys.get(i)));
            }
        }
        Collections.sort(result);
        return result;
    }

}
