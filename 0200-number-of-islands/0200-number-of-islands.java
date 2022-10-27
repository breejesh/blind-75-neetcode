class Solution {
    public int numIslands(char[][] grid) {
         int result = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    clearLand(grid, i, j);
                }
            }
        }
        return result;
    }
    
    private void clearLand(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        clearLand(grid, i + 1, j);
        clearLand(grid, i - 1, j);
        clearLand(grid, i, j + 1);
        clearLand(grid, i, j - 1);
        return;
    }
}