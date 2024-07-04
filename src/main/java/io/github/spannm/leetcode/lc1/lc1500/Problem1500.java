package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.*;

class Problem1500 extends LeetcodeProblem {

    static class FileSharing {
        private final int                        chunks;
        private int                              cur;
        private final TreeSet<Integer>           reused;
        private final Map<Integer, Set<Integer>> userChunks;

        FileSharing(int _m) {
            chunks = _m;
            cur = 0;
            reused = new TreeSet<>();
            userChunks = new TreeMap<>();
        }

        int join(List<Integer> _ownedChunks) {
            int userID;
            if (reused.isEmpty()) {
                cur++;
                userID = cur;
            } else {
                userID = reused.pollFirst();
            }
            userChunks.put(userID, new HashSet<>(_ownedChunks));
            return userID;
        }

        void leave(int _userId) {
            reused.add(_userId);
            userChunks.remove(_userId);
        }

        List<Integer> request(int _userId, int _chunkId) {
            if (_chunkId < 1 || _chunkId > chunks) {
                return List.of();
            }
            List<Integer> res = new ArrayList<>();
            for (Map.Entry<Integer, Set<Integer>> entry : userChunks.entrySet()) {
                if (entry.getValue().contains(_chunkId)) {
                    res.add(entry.getKey());
                }
            }
            if (!res.isEmpty()) {
                userChunks.computeIfAbsent(_userId, k -> new HashSet<>()).add(_chunkId);
            }
            return res;
        }

    }
}
