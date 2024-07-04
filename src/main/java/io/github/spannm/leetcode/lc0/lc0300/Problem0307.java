package io.github.spannm.leetcode.lc0.lc0300;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem0307 extends LeetcodeProblem {

    static class NumArray {
        private final SegmentTreeNode root;

        NumArray(int[] _nums) {
            root = buildSegmentTree(_nums, 0, _nums.length - 1);
        }

        SegmentTreeNode buildSegmentTree(int[] _nums, int _start, int _end) {
            if (_start > _end) {
                return null;
            } else {
                SegmentTreeNode r = new SegmentTreeNode(_start, _end);
                if (_start == _end) {
                    r.sum = _nums[_start];
                } else {
                    int mid = _start + (_end - _start) / 2;
                    r.left = buildSegmentTree(_nums, _start, mid);
                    r.right = buildSegmentTree(_nums, mid + 1, _end);
                    r.sum = r.left.sum + r.right.sum;
                }
                return r;
            }
        }

        void update(int _i, int _val) {
            update(root, _i, _val);
        }

        void update(SegmentTreeNode _root, int _pos, int _val) {
            if (_root.start == _root.end) {
                _root.sum = _val;
            } else {
                int mid = _root.start + (_root.end - _root.start) / 2;
                if (_pos <= mid) {
                    update(_root.left, _pos, _val);
                } else {
                    update(_root.right, _pos, _val);
                }
                _root.sum = _root.left.sum + _root.right.sum;
            }
        }

        public int sumRange(int _i, int _j) {
            return sumRange(root, _i, _j);
        }

        int sumRange(SegmentTreeNode _root, int _start, int _end) {
            if (_root.end == _end && _root.start == _start) {
                return _root.sum;
            } else {
                int mid = _root.start + (_root.end - _root.start) / 2;
                if (_end <= mid) {
                    return sumRange(_root.left, _start, _end);
                } else if (_start >= mid + 1) {
                    return sumRange(_root.right, _start, _end);
                } else {
                    return sumRange(_root.right, mid + 1, _end) + sumRange(_root.left, _start, mid);
                }
            }
        }

        static class SegmentTreeNode {
            private SegmentTreeNode left;
            private SegmentTreeNode right;
            private final int       start;
            private final int       end;
            private int             sum;

            SegmentTreeNode(int _start, int _end) {
                start = _start;
                end = _end;
                left = null;
                right = null;
                sum = 0;
            }
        }
    }

}
