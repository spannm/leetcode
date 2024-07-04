package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem2039 extends LeetcodeProblem {

    int networkBecomesIdle(int[][] _edges, int[] _patience) {
        int n = _patience.length;
        int[] distances = findShortestPathToMasterServer(_edges, n);
        int seconds = 0;
        for (int i = 1; i < n; i++) {
            int roundTripTime = distances[i] * 2;
            int numberOfMessages = roundTripTime / _patience[i];
            int lastMessageArriveTime = roundTripTime;
            if (roundTripTime > _patience[i]) {
                lastMessageArriveTime += _patience[i] * (roundTripTime % _patience[i] == 0 ? numberOfMessages - 1 : numberOfMessages);
            }
            seconds = Math.max(seconds, lastMessageArriveTime);
        }
        return seconds + 1;
    }

    private int[] findShortestPathToMasterServer(int[][] _edges, int _n) {
        int[] distances = new int[_n];
        Arrays.fill(distances, _n);
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Set<Integer>> neighborsMap = new HashMap<>();
        for (int[] edge : _edges) {
            if (edge[0] == 0) {
                queue.offer(edge[1]);
            }
            if (edge[1] == 0) {
                queue.offer(edge[0]);
            }
            Set<Integer> set1 = neighborsMap.getOrDefault(edge[0], new HashSet<>());
            set1.add(edge[1]);
            neighborsMap.put(edge[0], set1);
            Set<Integer> set2 = neighborsMap.getOrDefault(edge[1], new HashSet<>());
            set2.add(edge[0]);
            neighborsMap.put(edge[1], set2);
        }
        int distance = 1;
        boolean[] visited = new boolean[_n];
        visited[0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer curr = queue.poll();
                if (visited[curr]) {
                    continue;
                }
                visited[curr] = true;
                distances[curr] = Math.min(distance, distances[curr]);
                Set<Integer> neighbors = neighborsMap.getOrDefault(curr, new HashSet<>());
                for (int neighbor : neighbors) {
                    if (!visited[neighbor]) {
                        queue.offer(neighbor);
                    }
                }
            }
            distance++;
        }
        return distances;
    }

}
