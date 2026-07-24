class Solution {
    public int diagonalSum(int[][] mat) {
        // Write your code here
        int n = mat.length;
        int mainSum = 0;
        for(int i = 0;i<n;i++){
            mainSum += mat[i][i];
            mainSum += mat[i][n-1-i];
        }
        if(n % 2 == 1){
            mainSum -= mat[n/2][n/2];
        }
        return mainSum;
    }
}