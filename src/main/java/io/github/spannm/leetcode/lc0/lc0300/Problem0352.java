package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.TreeMap;

class Problem0352 extends LeetcodeProblem {

    static class SummaryRanges {

        private final TreeMap<Integer, Interval> tmap;

        SummaryRanges() {
            tmap = new TreeMap<>();
        }

        void addNum(int _val) {
            if (tmap.containsKey(_val)) {
                return;
            }
            Integer lower = tmap.lowerKey(_val);
            Integer higher = tmap.higherKey(_val);
            if (lower != null
                && higher != null
                && tmap.get(lower).end + 1 == _val
                && higher == _val + 1) {
                tmap.get(lower).end = tmap.get(higher).end;
                tmap.remove(higher);
            } else if (lower != null && tmap.get(lower).end + 1 >= _val) {
                tmap.get(lower).end = Math.max(tmap.get(lower).end, _val);
            } else if (higher != null && higher == _val + 1) {
                tmap.put(_val, new Interval(_val, tmap.get(higher).end));
                tmap.remove(higher);
            } else {
                tmap.put(_val, new Interval(_val, _val));
            }
        }

        int[][] getIntervals() {
            int[][] arr = new int[tmap.size()][2];
            int i = 0;
            for (Interval interval : tmap.values()) {
                arr[i++] = new int[] {interval.start, interval.end};
            }
            return arr;
        }

        static class Interval implements Comparable<Interval> {
            private final int start;
            private int       end;

            Interval() {
                this(0, 0);
            }

            Interval(int _start, int _end) {
                start = _start;
                end = _end;
            }

            @Override
            public boolean equals(Object _o) {
                if (this == _o) {
                    return true;
                } else if (!(_o instanceof Interval)) {
                    return false;
                }
                Interval interval = (Interval) _o;
                return start == interval.start && end == interval.end;
            }

            @Override
            public int hashCode() {
                int result = start;
                result = 31 * result + end;
                return result;
            }

            @Override
            public int compareTo(Interval _o) {
                int compareStart = _o.start;
                // ascending order
                return start - compareStart;
            }

            @Override
            public String toString() {
                return String.format("%s[%d, %d]", getClass().getSimpleName(), start, end);
            }

        }

    }

}
