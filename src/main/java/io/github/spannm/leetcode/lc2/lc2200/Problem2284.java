package io.github.spannm.leetcode.lc2.lc2200;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.HashMap;
import java.util.Map;

class Problem2284 extends LeetcodeProblem {

    String largestWordCount(String[] _messages, String[] _senders) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < _messages.length; i++) {
            String sender = _senders[i];
            int count = _messages[i].split(" ").length;
            Integer existing = map.getOrDefault(sender, 0);
            map.put(sender, existing + count);
        }
        int max = 0;
        String result = "";
        for (String sender : map.keySet()) {
            if (map.get(sender) > max) {
                max = map.get(sender);
                result = sender;
            } else if (map.get(sender) == max) {
                if (result.compareTo(sender) < 0) {
                    result = sender;
                }
            }
        }
        return result;
    }

}
