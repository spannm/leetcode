package io.github.spannm.leetcode.lc1.lc1600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/maximal-network-rank/">1615. Maximal Network Rank</a>.
 */
class Problem1615 extends LeetcodeProblem {

    int maximalNetworkRank(final int _cityCount, int[][] _roads) {

        // number of road connected to city
        int[] cityRoadCount = new int[_cityCount];

        // road exist between two two cities
        boolean[][] roadExists = new boolean[_cityCount][_cityCount];

        for (int[] cities : _roads) {
            // increment the count of numbers of connected city
            cityRoadCount[cities[0]]++;
            cityRoadCount[cities[1]]++;

            // mark road as existing between two cities
            roadExists[cities[0]][cities[1]] = true;
            roadExists[cities[1]][cities[0]] = true;
        }

        Map<Integer, Set<Integer>> citiesByRoadCount = new TreeMap<>(Comparator.reverseOrder());
        for (int city = 0; city < _cityCount; city++) {
            citiesByRoadCount.computeIfAbsent(cityRoadCount[city], v -> new TreeSet<>()).add(city);
        }

        List<Integer> candidateCities = new ArrayList<>();
        for (Set<Integer> cities : citiesByRoadCount.values()) {
            candidateCities.addAll(cities);
            if (candidateCities.size() > 1) {
                break;
            }
        }

        int maxRank = 0;
        for (Integer city1 : candidateCities) {
            for (Integer city2 : candidateCities) {
                if (!city1.equals(city2)) {
                    // count total number of road connected to both city
                    int rank = cityRoadCount[city1] + cityRoadCount[city2];

                    // just decrement the rank, if both city connected
                    if (roadExists[city1][city2]) {
                        rank--;
                    }
                    if (rank > maxRank) {
                        maxRank = rank;
                    }
                    if (!roadExists[city1][city2]) {
                        break; // no road exists between cities, must be the maximum
                    }
                }
            }
        }

        _roads = null;
        cityRoadCount = null;
        roadExists = null;
        citiesByRoadCount = null;
        candidateCities = null;
        System.gc();

        return maxRank;
    }

}
