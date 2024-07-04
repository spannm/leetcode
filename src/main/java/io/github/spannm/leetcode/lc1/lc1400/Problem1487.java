package io.github.spannm.leetcode.lc1.lc1400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem1487 extends LeetcodeProblem {

    String[] getFolderNames(String[] _names) {
        String[] result = new String[_names.length];
        Map<String, List<String>> map = new HashMap<>();
        Set<String> used = new HashSet<>();
        for (int i = 0; i < _names.length; i++) {
            if (!used.contains(_names[i])) {
                result[i] = _names[i];
                map.put(_names[i], new ArrayList<>());
                map.get(_names[i]).add(_names[i]);
                used.add(_names[i]);
            } else {
                List<String> list = map.get(_names[i]);
                int count = list.size();
                String newName = _names[i] + "(" + count + ")";
                while (used.contains(newName)) {
                    count++;
                    newName = _names[i] + "(" + count + ")";
                }
                result[i] = newName;
                map.get(_names[i]).add(newName);
                used.add(newName);

                map.put(newName, new ArrayList<>());
                map.get(newName).add(newName);
            }
        }
        return result;
    }

}
