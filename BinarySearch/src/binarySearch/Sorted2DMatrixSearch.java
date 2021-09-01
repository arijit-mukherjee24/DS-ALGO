package binarySearch;
// 74. Search a 2D Matrix https://leetcode.com/problems/search-a-2d-matrix/
class Sorted2DMatrixSearch {
    private static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) {
            return false;
        }
        
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        
        int start = 0, end = numRows*numCols - 1;
        
        while(start <= end) {
            int mid = (start+end)/2;
            int midValue = matrix[mid/numCols][mid%numCols];
            if(target == midValue) {
                return true;
            } else if (target < midValue) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        int[][]matrix = {
            {1, 5, 9, 11},
            {13, 16, 19, 24},
            {28, 30, 38, 50}
        };
        
        int target = 50;
        
        System.out.println(searchMatrix(matrix, target));
    }
}
