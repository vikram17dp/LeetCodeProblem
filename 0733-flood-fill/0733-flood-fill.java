class Solution { // tc and sc is O(m * n)
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Get the original color of the starting pixel
        int originalColor = image[sr][sc];

        // If the starting pixel's color is already the new color, no changes are needed.
        // This also prevents infinite recursion if originalColor == color.
        if (originalColor == color) {
            return image;
        }

        dfs(image,sr,sc,originalColor,color);
        return image;
    }

    private void dfs(int[][] image,int r,int c,int originalColor,int newColor){
        int m = image.length;
        int n = image[0].length;

         // Base cases for recursion:
        // 1. Out of bounds
        // 2. Pixel does not have the original color (meaning it's already changed or never was part of the component)
        if (r < 0 || r >= m || c < 0 || c >= n || image[r][c] != originalColor) {
            return;
        }
        // change the colour of the current pixel
        image[r][c] = newColor;

        // Recursively call DFS for all 4-directionally adjacent pixels
        dfs(image, r + 1, c, originalColor, newColor); // Down
        dfs(image, r - 1, c, originalColor, newColor); // Up
        dfs(image, r, c + 1, originalColor, newColor); // Right
        dfs(image, r, c - 1, originalColor, newColor); // Left
    }
}