package io.github.spannm.leetcode.lc2.lc2400;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.*;

/**
 * 2471. Minimum Number of Operations to Sort a Binary Tree by Level.
 */
class Problem2471 extends LeetcodeProblem {

    int minimumOperations(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int ans = 0;
        while (!q.isEmpty()) {
            List<Integer> t = new ArrayList<>();
            for (int n = q.size(); n > 0; n--) {
                TreeNode node = q.poll();
                t.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            ans += f(t);
        }
        return ans;
    }

    private int f(List<Integer> t) {
        int n = t.size();
        List<Integer> alls = new ArrayList<>(t);
        alls.sort(Comparator.comparingInt(a -> a));
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            m.put(alls.get(i), i);
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = m.get(t.get(i));
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (arr[i] != i) {
                swap(arr, i, arr[i]);
                ans++;
            }
        }
        return ans;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
