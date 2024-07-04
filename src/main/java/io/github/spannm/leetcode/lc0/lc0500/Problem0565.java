package io.github.spannm.leetcode.lc0.lc0500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0565 extends LeetcodeProblem {

    int arrayNesting(int[] _nums) {
        if (_nums == null) {
            return 0;
        }
        int len = _nums.length;
        if (len == 0) {
            return 0;
        }
        boolean[] visited = new boolean[len];
        int answer = 0;
        for (int i : _nums) {
            int count = 0;
            int j = i;
            while (j >= 0 && j < len && !visited[j]) {
                count++;
                visited[j] = true;
                j = _nums[j];
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }

}
