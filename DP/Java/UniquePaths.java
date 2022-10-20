// leetcode medium
// https://leetcode.com/problems/unique-paths/
class Solution {

    public int uniquePaths(int m, int n) {
        // create a 2D array to store results of sub-problems...
        int paths[][] = new int[m][n];
        // To reach any cell in first column is 1...
        for (int i = 0; i < m; i++) paths[i][0] = 1;
        // To reach any cell in first row is 1...
        for (int j = 0; j < n; j++) paths[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
        }
        return paths[m - 1][n - 1]; // Return the result...
    }
}
