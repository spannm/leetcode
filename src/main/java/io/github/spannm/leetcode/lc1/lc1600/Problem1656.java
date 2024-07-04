package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Problem1656 extends LeetcodeProblem {

    static class OrderedStream {
        private final Map<Integer, String> map;
        private int                        ptr;
        private final int                  limit;

        OrderedStream(int _n) {
            map = new TreeMap<>();
            ptr = 1;
            limit = _n;
        }

        List<String> insert(int _id, String _value) {
            map.put(_id, _value);
            List<String> result = new ArrayList<>();
            if (map.containsKey(ptr)) {
                for (int key = ptr; key <= limit; key++) {
                    if (map.containsKey(key)) {
                        result.add(map.get(key));
                    } else {
                        break;
                    }
                }
                int i = _id;
                while (map.containsKey(i)) {
                    i++;
                }
                ptr = i;
            }
            return result;
        }
    }

}
