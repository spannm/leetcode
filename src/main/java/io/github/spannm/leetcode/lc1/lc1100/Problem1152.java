package io.github.spannm.leetcode.lc1.lc1100;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem1152 extends LeetcodeProblem {

    List<String> mostVisitedPattern(String[] _username, int[] _timestamp, String[] _website) {
        Map<String, Map<Integer, String>> userToSiteMap = new HashMap<>();
        for (int i = 0; i < _username.length; i++) {
            if (!userToSiteMap.containsKey(_username[i])) {
                userToSiteMap.put(_username[i], new TreeMap<>());
            }
            Map<Integer, String> timeToSiteMap = userToSiteMap.get(_username[i]);
            timeToSiteMap.put(_timestamp[i], _website[i]);
            userToSiteMap.put(_username[i], timeToSiteMap);
        }
        Map<String, Integer> sequenceCountMap = new HashMap<>();
        for (String user : userToSiteMap.keySet()) {
            Map<Integer, String> timeToSiteMap = userToSiteMap.get(user);
            if (timeToSiteMap.size() >= 3) {
                List<Integer> times = new ArrayList<>(timeToSiteMap.keySet());
                List<String> allSequences = formAllSequences(times, timeToSiteMap);
                Set<String> encounteredSequence = new HashSet<>();
                for (String sequence : allSequences) {
                    if (encounteredSequence.add(sequence)) {
                        sequenceCountMap.put(sequence, sequenceCountMap.getOrDefault(sequence, 0) + 1);
                    }
                }
            }
        }
        int count = 0;
        String result = null;
        for (String sequence : sequenceCountMap.keySet()) {
            if (sequenceCountMap.get(sequence) > count) {
                result = sequence;
                count = sequenceCountMap.get(sequence);
            } else if (count == sequenceCountMap.get(sequence)) {
                if (sequence.compareTo(result) < 0) {
                    result = sequence;
                }
            }
        }
        return List.of(result.split("->"));
    }

    static List<String> formAllSequences(List<Integer> _times, Map<Integer, String> _timeToSiteMap) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < _times.size() - 2; i++) {
            for (int j = i + 1; j < _times.size() - 1; j++) {
                for (int k = j + 1; k < _times.size(); k++) {
                    result.add(_timeToSiteMap.get(_times.get(i)) + "->" + _timeToSiteMap.get(_times.get(j)) + "->" + _timeToSiteMap.get(_times.get(k)));
                }
            }
        }
        return result;
    }

}
