package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.LinkedList;
import java.util.List;

class Problem0635 extends LeetcodeProblem {

    static class LogSystem {

        private final List<String[]> timestamps;
        private final List<String>   units;
        private final int[]          indices;

        LogSystem() {
            timestamps = new LinkedList<>();
            units = List.of("Year", "Month", "Day", "Hour", "Minute", "Second");
            indices = new int[] {4, 7, 10, 13, 16, 19};
        }

        void put(int _id, String _timestamp) {
            timestamps.add(new String[] {Integer.toString(_id), _timestamp});
        }

        List<Integer> retrieve(String _s, String _e, String _gra) {
            List<Integer> res = new LinkedList<>();
            int index = units.indexOf(_gra);
            int stringEnd = indices[index];
            for (String[] timestamp : timestamps) {
                if (timestamp[1].substring(0, stringEnd).compareTo(_s.substring(0, stringEnd)) >= 0
                    && timestamp[1].substring(0, stringEnd).compareTo(_e.substring(0, stringEnd)) <= 0) {
                    res.add(Integer.parseInt(timestamp[0]));
                }
            }
            return res;
        }
    }

}
