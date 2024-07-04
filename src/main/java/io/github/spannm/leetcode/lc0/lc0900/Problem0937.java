package io.github.spannm.leetcode.lc0.lc0900;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Problem0937 extends LeetcodeProblem {

    String[] reorderLogFiles(String[] _logs) {
        Map<String, String> letterLogMap = new TreeMap<>();
        List<String> digitLogList = new ArrayList<>();
        for (String log : _logs) {
            int firstSpaceIndex = log.indexOf(' ');
            String id = log.substring(0, firstSpaceIndex);
            if (Character.isAlphabetic(log.charAt(firstSpaceIndex + 1))) {
                String key = log.substring(firstSpaceIndex + 1) + id;
                letterLogMap.put(key, log);
            } else {
                digitLogList.add(log);
            }
        }
        String[] reorderedLogs = new String[_logs.length];
        int i = 0;
        for (String key : letterLogMap.keySet()) {
            reorderedLogs[i++] = letterLogMap.get(key);
        }
        for (String log : digitLogList) {
            reorderedLogs[i++] = log;
        }
        return reorderedLogs;
    }

}
