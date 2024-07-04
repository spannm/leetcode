package io.github.spannm.leetcode.lc2.lc2000;

import io.github.spannm.leetcode.LeetcodeProblem;

/**
 * 2061. Number of Spaces Cleaning Robot Cleaned.
 */
class Problem2061 extends LeetcodeProblem {

    private int[][]       room;
    private boolean[][][] vis;
    private int           ans;

    int numberOfCleanRooms(int[][] _room) {
        room = _room;
        vis = new boolean[_room.length][_room[0].length][4];
        dfs(0, 0, 0);
        return ans;
    }

    private void dfs(int i, int j, int k) {
        if (vis[i][j][k]) {
            return;
        }
        int[] dirs = {0, 1, 0, -1, 0};
        ans += room[i][j] == 0 ? 1 : 0;
        room[i][j] = -1;
        vis[i][j][k] = true;
        int x = i + dirs[k];
        int y = j + dirs[k + 1];
        if (x >= 0 && x < room.length && y >= 0 && y < room[0].length && room[x][y] != 1) {
            dfs(x, y, k);
        } else {
            dfs(i, j, (k + 1) % 4);
        }
    }

}
