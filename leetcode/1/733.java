class Solution {
    /** BFS */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int origin = image[sr][sc];
        if (origin == color) return image;
        int rows = image.length;
        int cols = image[0].length;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});
        image[sr][sc] = color;
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (image[nr][nc] == origin) {
                    image[nr][nc] = color;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return image;
    }

    /** DFS */
    public int[][] floodFillDFS(int[][] image, int sr, int sc, int color) {
        int origin = image[sr][sc];
        if(origin == color) return image;
        dfs(image, sr, sc, origin, color);
        return image;
    }
    private void dfs(int[][] image, int r, int c, int origin, int color){
        int rows = image.length;
        int cols = image[0].length;
        if(r < 0 || r >= rows || c < 0 || c >= cols) return;
        if(image[r][c] != origin) return;
        image[r][c] = color;
        dfs(image, r + 1, c, origin, color);
        dfs(image, r - 1, c, origin, color);
        dfs(image, r, c + 1, origin, color);
        dfs(image, r, c - 1, origin, color);
    }
}
