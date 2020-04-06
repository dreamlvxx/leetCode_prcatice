package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeeCode200 {
    int count;
    int m, n;

    /**
     * DFS
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (null == grid) {
            return 0;
        }
        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    find(grid, i, j);
                }
            }
        }
        return count;
    }

    public void find(char[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        find(grid, i - 1, j);
        find(grid, i + 1, j);
        find(grid, i, j - 1);
        find(grid, i, j + 1);
    }

    /**
     * BFS
     *
     * @param grid
     * @return
     */
    public int numIslands1(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfsFill(grid, i, j);
                    count++;
                }
            }
        return count;
    }

    private void bfsFill(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        int n = grid.length;
        int m = grid[0].length;
        LinkedList<Integer> queue = new LinkedList<>();
        int code = x * m + y;
        queue.offer(code);
        while (!queue.isEmpty()) {
            code = queue.poll();
            int i = code / m;
            int j = code % m;
            if (i > 0 && grid[i - 1][j] == '1')   //up
            {
                queue.offer((i - 1) * m + j);
                grid[i - 1][j] = '0';
            }
            if (i < n - 1 && grid[i + 1][j] == '1')  //down
            {
                queue.offer((i + 1) * m + j);
                grid[i + 1][j] = '0';
            }
            if (j > 0 && grid[i][j - 1] == '1')  //left
            {
                queue.offer(i * m + j - 1);
                grid[i][j - 1] = '0';
            }
            if (j < m - 1 && grid[i][j + 1] == '1')  //right
            {
                queue.offer(i * m + j + 1);
                grid[i][j + 1] = '0';
            }
        }
    }
}
