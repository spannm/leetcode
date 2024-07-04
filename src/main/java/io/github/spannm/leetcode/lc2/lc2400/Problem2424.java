package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashSet;
import java.util.Set;

class Problem2424 extends LeetcodeProblem {

    static class LUPrefix {
        private final int          nbVideos;
        private int                r;
        private final Set<Integer> s = new HashSet<>();

        LUPrefix(int _n) {
            nbVideos = _n;
        }

        void upload(int _video) {
            s.add(_video);
            while (s.contains(r + 1)) {
                r++;
            }
        }

        int longest() {
            return r;
        }

        int getNbVideos() {
            return nbVideos;
        }

    }

}
