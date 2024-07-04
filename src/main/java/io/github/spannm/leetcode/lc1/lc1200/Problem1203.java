package io.github.spannm.leetcode.lc1.lc1200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/sort-items-by-groups-respecting-dependencies/">1203. Sort Items by Groups
 * Respecting Dependencies</a>.
 */
class Problem1203 extends LeetcodeProblem {

    int[] sortItems(int _itemCount, int _groupCount, int[] _groups, List<List<Integer>> _beforeItems) {

        Map<Integer, List<Integer>> map = new java.util.concurrent.ConcurrentHashMap<>();
        Map<Integer, List<Integer>> groupGraph = new java.util.concurrent.ConcurrentHashMap<>();
        Map<Integer, List<Integer>> inGroupGraph = new java.util.concurrent.ConcurrentHashMap<>();
        Map<Integer, Integer> groupDegrees = new java.util.concurrent.ConcurrentHashMap<>();
        int[] arrDegrees = new int[_itemCount];
        int[] gr = new int[_itemCount];

        for (int i = 0; i < _itemCount; i++) {
            if (_groups[i] > -1) {
                gr[i] = _groups[i];
            } else {
                gr[i] = i + _groupCount + 1;
            }
            inGroupGraph.put(i, new ArrayList<>());
            groupDegrees.putIfAbsent(gr[i], 0);
            groupGraph.computeIfAbsent(gr[i], k -> new ArrayList<>());
        }

        for (int i = 0; i < _beforeItems.size(); i++) {
            map.computeIfAbsent(gr[i], k -> new ArrayList<>());
            map.get(gr[i]).add(i);
            List<Integer> biList = _beforeItems.get(i);
            for (int bi : biList) {
                if (gr[i] == gr[bi]) {
                    inGroupGraph.get(bi).add(i);
                    arrDegrees[i]++;
                } else {
                    groupGraph.get(gr[bi]).add(gr[i]);
                    groupDegrees.put(gr[i], groupDegrees.getOrDefault(gr[i], 0) + 1);
                }
            }
        }

        int[] result = new int[_itemCount];
        int index = 0;
        java.util.Queue<Integer> q1 = new java.util.LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : groupDegrees.entrySet()) {
            if (entry.getValue() == 0) {
                q1.add(entry.getKey());
            }
        }

        java.util.Queue<Integer> q2 = new java.util.LinkedList<>();
        while (!q1.isEmpty()) {
            int num = q1.poll();
            for (int x : groupGraph.get(num)) {
                groupDegrees.put(x, groupDegrees.get(x) - 1);
                if (groupDegrees.get(x) == 0) {
                    q1.add(x);
                }
            }
            q2.clear();
            for (Integer y : map.get(num)) {
                if (arrDegrees[y] == 0) {
                    q2.add(y);
                }
            }
            while (!q2.isEmpty()) {
                int temp = q2.poll();
                result[index++] = temp;
                for (Integer y : inGroupGraph.get(temp)) {
                    arrDegrees[y]--;
                    if (arrDegrees[y] == 0) {
                        q2.add(y);
                    }
                }
            }

        }

        result = index == arrDegrees.length ? result : new int[0];

        map = null;
        groupGraph = null;
        inGroupGraph = null;
        groupDegrees = null;
        arrDegrees = null;
        gr = null;
        q1 = null;
        q2 = null;
        System.gc();

        return result;
    }

}
