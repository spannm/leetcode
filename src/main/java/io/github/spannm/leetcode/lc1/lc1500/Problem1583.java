package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.LinkedHashMap;
import java.util.Map;

class Problem1583 extends LeetcodeProblem {

    int unhappyFriends(int _n, int[][] _preferences, int[][] _pairs) {
        int unhappyFriends = 0;
        Map<Integer, Integer> assignedPair = new LinkedHashMap<>();
        for (int[] pair : _pairs) {
            assignedPair.put(pair[0], pair[1]);
            assignedPair.put(pair[1], pair[0]);
        }
        for (int[] pair : _pairs) {
            if (isUnhappy(pair[1], pair[0], _preferences, assignedPair)) {
                unhappyFriends++;
            }
            if (isUnhappy(pair[0], pair[1], _preferences, assignedPair)) {
                unhappyFriends++;
            }
        }
        return unhappyFriends;
    }

    private static boolean isUnhappy(int _self, int _assignedFriend, int[][] _preferences, Map<Integer, Integer> _assignedPairs) {
        int[] preference = _preferences[_self];
        int assignedFriendPreferenceIndex = findIndex(preference, _assignedFriend);
        for (int i = 0; i <= assignedFriendPreferenceIndex; i++) {
            int preferredFriend = preference[i];
            int preferredFriendAssignedFriend = _assignedPairs.get(preferredFriend);
            if (preferredFriendAssignedFriend == _self) {
                return false;
            }
            int candidateAssignedFriendIndex = findIndex(_preferences[preferredFriend], preferredFriendAssignedFriend);
            if (isPreferred(_self, _preferences[preferredFriend], candidateAssignedFriendIndex)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPreferred(int _self, int[] _preference, int _boundary) {
        for (int i = 0; i <= _boundary; i++) {
            if (_self == _preference[i]) {
                return true;
            }
        }
        return false;
    }

    private static int findIndex(int[] _preference, int _assignedFriend) {
        for (int i = 0; i < _preference.length; i++) {
            if (_preference[i] == _assignedFriend) {
                return i;
            }
        }
        return 0;
    }

}
