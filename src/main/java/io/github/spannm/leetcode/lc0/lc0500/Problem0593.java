package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem0593 extends LeetcodeProblem {

    boolean validSquare(int[] _p1, int[] _p2, int[] _p3, int[] _p4) {
        List<int[]> input = new ArrayList<>(List.of(_p1, _p2, _p3, _p4));
        List<List<int[]>> allPermuations = getAllPermutations(input);
        for (List<int[]> eachPermutation : allPermuations) {
            if (isValid(eachPermutation)) {
                return true;
            }
        }
        return false;
    }

    static List<List<int[]>> getAllPermutations(List<int[]> _input) {
        List<List<int[]>> result = new ArrayList<>();
        List<int[]> init = new ArrayList<>();
        result.add(init);
        return backTrack(result, _input, 0);
    }

    static List<List<int[]>> backTrack(List<List<int[]>> _result, List<int[]> _input, int _pos) {
        if (_pos == _input.size()) {
            return _result;
        }
        List<List<int[]>> newResult = new ArrayList<>();
        for (List<int[]> eachList : _result) {
            for (int i = 0; i <= eachList.size(); i++) {
                List<int[]> newList = new ArrayList<>(eachList);
                newList.add(i, _input.get(_pos));
                newResult.add(newList);
            }
        }
        _result = newResult;
        return backTrack(_result, _input, _pos + 1);
    }

    private static boolean isValid(List<int[]> _points) {
        int[] p1 = _points.get(0);
        int[] p2 = _points.get(1);
        int[] p3 = _points.get(2);
        int[] p4 = _points.get(3);
        double distance = Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2);
        return distance == Math.pow(p2[0] - p3[0], 2) + Math.pow(p2[1] - p3[1], 2)
            && distance == Math.pow(p3[0] - p4[0], 2) + Math.pow(p3[1] - p4[1], 2)
            && distance == Math.pow(p4[0] - p1[0], 2) + Math.pow(p4[1] - p1[1], 2)
            && isRightAngle(p1, p2, p3)
            && noDuplicate(p1, p2, p3, p4);
    }

    static boolean noDuplicate(int[] _p1, int[] _p2, int[] _p3, int[] _p4) {
        return !Arrays.equals(_p1, _p2)
            && !Arrays.equals(_p1, _p3)
            && !Arrays.equals(_p1, _p4)
            && !Arrays.equals(_p2, _p3)
            && !Arrays.equals(_p2, _p4)
            && !Arrays.equals(_p3, _p4);
    }

    static boolean isRightAngle(int[] _p1, int[] _p2, int[] _p3) {
        double angle1 = Math.atan2(_p2[1] - _p1[1], _p2[0] - _p1[0]);
        double angle2 = Math.atan2(_p3[1] - _p1[1], _p3[0] - _p1[0]);
        double degree = Math.toDegrees(angle1 - angle2);
        return degree % 45 == 0;
    }

}
