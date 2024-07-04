package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

class Problem0218 extends LeetcodeProblem {

    List<List<Integer>> getSkyline(int[][] _buildings) {
        BuildingPoint[] bps = new BuildingPoint[_buildings.length * 2];
        int index = 0;
        for (int[] building : _buildings) {
            BuildingPoint bp1 = new BuildingPoint(building[0], true, building[2]);
            BuildingPoint bp2 = new BuildingPoint(building[1], false, building[2]);
            bps[index++] = bp1;
            bps[index++] = bp2;
        }

        Arrays.sort(bps);

        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        tmap.put(0, 1);
        int prevMaxH = 0;
        for (BuildingPoint bp : bps) {

            if (bp.isStart) {
                tmap.compute(bp.h, (k, v) -> v == null ? 1 : v + 1);
            } else {

                if (tmap.containsKey(bp.h) && tmap.get(bp.h) > 1) {
                    tmap.put(bp.h, tmap.get(bp.h) - 1);
                } else {
                    tmap.remove(bp.h);
                }
            }

            int currMaxH = tmap.lastKey();
            if (currMaxH != prevMaxH) {
                result.add(List.of(bp.x, currMaxH));
                prevMaxH = currMaxH;
            }

        }

        return result;
    }

    static class BuildingPoint implements Comparable<BuildingPoint> {
        private final int     x;
        private final boolean isStart;
        private final int     h;

        BuildingPoint(int _x, boolean _isStart, int _h) {
            x = _x;
            h = _h;
            isStart = _isStart;
        }

        @Override
        public int compareTo(BuildingPoint _o) {
            if (x != _o.x) {
                return x - _o.x;
            } else if (isStart && _o.isStart) {
                return _o.h - h;
            } else if (isStart && !_o.isStart) {
                return -h - _o.h;
            } else if (!isStart && !_o.isStart) {
                return h - _o.h;
            } else {
                return h + _o.h;
            }
        }
    }

}
