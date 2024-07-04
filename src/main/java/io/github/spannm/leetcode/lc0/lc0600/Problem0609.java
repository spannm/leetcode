package io.github.spannm.leetcode.lc0.lc0600;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Problem0609 extends LeetcodeProblem {

    List<List<String>> findDuplicate(String[] _paths) {
        Map<String, List<String>> contentMap = new HashMap<>();
        for (String path : _paths) {
            String[] contents = path.split(" ");
            for (int i = 1; i < contents.length; i++) {
                int start = contents[i].indexOf('(');
                int end = contents[i].indexOf(')');
                String content = contents[i].substring(start + 1, end);
                contentMap.computeIfAbsent(content, k -> new ArrayList<>())
                    .add(contents[0] + "/" + contents[i].substring(0, start));
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (String key : contentMap.keySet()) {
            List<String> content = contentMap.get(key);
            if (content.size() > 1) {
                result.add(content);
            }
        }
        return result;
    }

}
