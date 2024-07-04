package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/design-underground-system/">1396. Design Underground System</a>.
 */
class Problem1396 extends LeetcodeProblem {

    static class UndergroundSystem {

        private final Map<Integer, Checkin>                   checkins = new LinkedHashMap<>();
        private final Map<String, Map<String, List<Integer>>> times    = new LinkedHashMap<>();

        UndergroundSystem() {
        }

        void checkIn(int _id, String _stationName, int _time) {
            if (checkins.containsKey(_id)) {
                throw new IllegalArgumentException(_id + " already checked in");
            }
            checkins.put(_id, new Checkin(_id, _stationName, _time));
            times.computeIfAbsent(_stationName, k -> new LinkedHashMap<>());
        }

        void checkOut(int _id, String _stationName, int _time) {
            Checkin checkin = checkins.remove(_id);
            if (checkin == null) {
                throw new IllegalArgumentException(_id + " not checked in");
            }
            times.get(checkin.stationName).computeIfAbsent(_stationName, k -> new ArrayList<>());
            times.get(checkin.stationName).get(_stationName).add(_time - checkin.time);
        }

        double getAverageTime(String _startStation, String _endStation) {
            List<Integer> l = times.get(_startStation).get(_endStation);
            return l == null ? 0d : l.stream().mapToInt(Integer::intValue).summaryStatistics().getAverage();
        }

        static final class Checkin {
            private final int    id;
            private final String stationName;
            private final int    time;

            Checkin(int _id, String _stationName, int _time) {
                id = _id;
                stationName = _stationName;
                time = _time;
            }

            int getId() {
                return id;
            }
        }

    }

}
