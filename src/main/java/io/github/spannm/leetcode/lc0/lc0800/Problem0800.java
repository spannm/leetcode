package io.github.spannm.leetcode.lc0.lc0800;

import io.github.spannm.leetcode.LeetcodeProblem;

import java.util.ArrayList;
import java.util.List;

class Problem0800 extends LeetcodeProblem {

    String similarRGB(String _color) {
        List<String> allShortHandCombinations = computeAllShorthandCombinations();
        int minSimilarity = Integer.MIN_VALUE;
        String result = "";
        for (String candidate : allShortHandCombinations) {
            int similarity = computeSimilarity(candidate, _color);
            if (similarity > minSimilarity) {
                result = candidate;
                minSimilarity = similarity;
            }
        }
        return result;
    }

    private int computeSimilarity(String _candidate, String _color) {
        return -(Integer.parseInt(_candidate.substring(1, 3), 16) - Integer.parseInt(
            _color.substring(1, 3), 16)) * (Integer.parseInt(_candidate.substring(1, 3), 16)
                - Integer.parseInt(_color.substring(1, 3), 16))
            - (Integer.parseInt(_candidate.substring(3, 5), 16) - Integer.parseInt(
                _color.substring(3, 5), 16)) * (Integer.parseInt(_candidate.substring(3, 5), 16)
                    - Integer.parseInt(_color.substring(3, 5), 16))
            - (Integer.parseInt(_candidate.substring(5, 7), 16) - Integer.parseInt(
                _color.substring(5, 7), 16)) * (Integer.parseInt(_candidate.substring(5, 7), 16)
                    - Integer.parseInt(_color.substring(5, 7), 16));
    }

    private List<String> computeAllShorthandCombinations() {
        List<String> result = new ArrayList<>();
        List<Character> hexNumber = new ArrayList<>(
            List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'));
        for (int i = 0; i < hexNumber.size(); i++) {
            for (int j = 0; j < hexNumber.size(); j++) {
                for (Character character : hexNumber) {
                    String sb = "#"
                        + hexNumber.get(i)
                        + hexNumber.get(i)
                        + hexNumber.get(j)
                        + hexNumber.get(j)
                        + character
                        + character;
                    result.add(sb);
                }
            }
        }
        return result;
    }

}
