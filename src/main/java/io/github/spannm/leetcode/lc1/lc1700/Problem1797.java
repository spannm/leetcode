package io.github.spannm.leetcode.lc1.lc1700;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem1797 extends LeetcodeProblem {

    static class AuthenticationManager {

        private final int                  timeToLive;
        private final Map<String, Integer> map;

        AuthenticationManager(int _timeToLive) {
            timeToLive = _timeToLive;
            map = new HashMap<>();
        }

        void generate(String _tokenId, int _currentTime) {
            map.put(_tokenId, _currentTime + timeToLive);
        }

        void renew(String _tokenId, int _currentTime) {
            Integer expireTime = map.getOrDefault(_tokenId, -1);
            if (expireTime == -1 || expireTime <= _currentTime) {
                return;
            }
            map.put(_tokenId, _currentTime + timeToLive);
        }

        int countUnexpiredTokens(int _currentTime) {
            Map<String, Integer> tmp = new HashMap<>();
            for (String token : map.keySet()) {
                if (map.get(token) > _currentTime) {
                    tmp.put(token, map.get(token));
                }
            }
            map.clear();
            map.putAll(tmp);
            return map.size();
        }
    }

}
