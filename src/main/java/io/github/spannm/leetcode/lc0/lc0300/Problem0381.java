package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem0381 extends LeetcodeProblem {

    static class RandomizedCollection {

        private final Map<Integer, Set<Integer>> m   = new HashMap<>();
        private final List<Integer>              l   = new ArrayList<>();
        private final Random                     rnd = new Random();

        public boolean insert(int _val) {
            m.computeIfAbsent(_val, k -> new HashSet<>()).add(l.size());
            l.add(_val);
            return m.get(_val).size() == 1;
        }

        public boolean remove(int _val) {
            if (!m.containsKey(_val)) {
                return false;
            }
            Set<Integer> idxSet = m.get(_val);
            int idx = idxSet.iterator().next();
            int lastIdx = l.size() - 1;
            l.set(idx, l.get(lastIdx));
            idxSet.remove(idx);

            Set<Integer> lastIdxSet = m.get(l.get(lastIdx));
            lastIdxSet.remove(lastIdx);
            if (idx < lastIdx) {
                lastIdxSet.add(idx);
            }
            if (idxSet.isEmpty()) {
                m.remove(_val);
            }
            l.remove(lastIdx);
            return true;
        }

        public int getRandom() {
            int size = l.size();
            return size == 0 ? -1 : l.get(rnd.nextInt(size));
        }

    }

}
