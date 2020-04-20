package common_check;

public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

        System.out.println(minPathSum(grid));
    }

    static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] array = new int[m][n];

        array[0][0] = grid[0][0];

        // fill up first row, since second position, every value equal to grid current +
        // current - 1
        for (int i = 1; i < n; i++) {
            array[0][i] = array[0][i - 1] + grid[0][i];
        }

        // fill up first column, since second position, every value equal to grid
        // current + current - 1
        for (int i = 1; i < m; i++) {
            array[i][0] = array[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (array[i - 1][j] > array[i][j - 1]) {
                    array[i][j] = array[i][j - 1] + grid[i][j];
                } else {
                    array[i][j] = array[i - 1][j] + grid[i][j];
                }
            }
        }

        return array[m - 1][n - 1];
    }
}