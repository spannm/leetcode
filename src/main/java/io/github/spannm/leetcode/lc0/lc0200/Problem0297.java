package io.github.spannm.leetcode.lc0.lc0200;

import io.github.spannm.leetcode.LeetcodeProblem;
import io.github.spannm.leetcode.dep.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Problem0297 extends LeetcodeProblem {

    static class Codec {
        public String serialize(TreeNode _root) {
            if (_root == null) {
                return "";
            }

            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(_root);
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode curr = q.poll();
                    if (curr == null) {
                        sb.append("# ");
                    } else {
                        sb.append(curr.val).append(" ");
                        q.offer(curr.left);
                        q.offer(curr.right);
                    }
                }
            }
            return sb.toString();
        }

        public TreeNode deserialize(String _data) {
            if (_data == null || _data.isEmpty()) {
                return null;
            }

            String[] nodes = _data.split(" ");
            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            for (int i = 1; i < nodes.length; i++) {
                TreeNode curr = queue.poll();
                if (!nodes[i].equals("#")) {
                    curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                    queue.offer(curr.left);
                }
                if (!nodes[++i].equals("#")) {
                    curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                    queue.offer(curr.right);
                }
            }
            return root;
        }

    }

}
