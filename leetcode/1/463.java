class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    for (int i = 0; i < 4; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];
                        if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || grid[nr][nc] == 0) perimeter++;
                    }
                }
            }
        }
        return perimeter;
    }
}