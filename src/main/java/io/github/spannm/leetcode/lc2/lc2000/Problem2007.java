package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Problem2007 extends LeetcodeProblem {

    int[] findOriginalArray(int[] _changed) {
        if (_changed.length % 2 != 0) {
            return new int[] {};
        }
        Arrays.sort(_changed);
        int[] ans = new int[_changed.length / 2];
        int k = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int element : _changed) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }
        for (int i = _changed.length - 1; i >= 0; i--) {
            int doubledNumber = _changed[i];
            if (map.containsKey(doubledNumber)) {
                int doubledNumberCount = map.get(doubledNumber);
                int halfNumber = doubledNumber / 2;
                if (!map.containsKey(halfNumber) || map.get(halfNumber) < doubledNumberCount || halfNumber * 2 != doubledNumber) {
                    return new int[] {};
                } else {
                    if (doubledNumber == halfNumber && map.get(halfNumber) % 2 == 0) {
                        doubledNumberCount /= 2;
                        while (doubledNumberCount-- > 0) {
                            ans[k++] = halfNumber;
                        }
                        map.remove(halfNumber);
                    } else {
                        map.put(halfNumber, map.get(halfNumber) - doubledNumberCount);
                        if (map.get(halfNumber) == 0) {
                            map.remove(halfNumber);
                        }
                        while (doubledNumberCount-- > 0) {
                            ans[k++] = halfNumber;
                        }
                        map.remove(doubledNumber);
                    }
                }
            }
        }
        return ans;
    }

}
