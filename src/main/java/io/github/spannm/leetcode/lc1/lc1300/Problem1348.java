package io.github.spannm.leetcode.lc1.lc1300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem1348 extends LeetcodeProblem {

    static class TweetCounts {
        private final Map<String, TreeMap<Integer, Integer>> map = new HashMap<>();

        void recordTweet(String _tweetName, int _time) {
            map.computeIfAbsent(_tweetName, k -> new TreeMap<>()).merge(_time, 1, Integer::sum);
        }

        List<Integer> getTweetCountsPerFrequency(String _freq, String _tweetName, int _startTime, int _endTime) {
            if (!map.containsKey(_tweetName)) {
                return null;
            }
            int interval;
            if ("minute".equals(_freq)) {
                interval = 60;
            } else if ("hour".equals(_freq)) {
                interval = 60 * 60;
            } else {
                interval = 60 * 60 * 24;
            }
            int size = (_endTime - _startTime) / interval + 1;
            int[] buckets = new int[size];
            TreeMap<Integer, Integer> tweetMap = map.get(_tweetName);
            for (Map.Entry<Integer, Integer> entry : tweetMap.subMap(_startTime, _endTime + 1).entrySet()) {
                int index = (entry.getKey() - _startTime) / interval;
                buckets[index] += entry.getValue();
            }
            List<Integer> result = new ArrayList<>();
            for (int num : buckets) {
                result.add(num);
            }
            return result;
        }
    }

}
