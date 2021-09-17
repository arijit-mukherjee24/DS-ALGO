package com.matrix;

import java.util.ArrayList;

// Ref: https://www.youtube.com/watch?v=63fPPOdIr2c Take u forward
// Code: https://github.com/striver79/SDESheet/blob/main/matrixMedianJava
public class MedianRowWiseSortedMatrix {

	public static void main(String[] args) {
		int r = 3, c = 3;
        int m[][]= { {1,3,5}, {2,6,9}, {3,6,9} };
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < r; i++) {
        	ArrayList<Integer> rowList = new ArrayList<Integer>();
        	for( int j = 0; j< c; j++) {
        		rowList.add(m[i][j]);
        	}
        	list.add(rowList);
        }
        int ans  = findMedian(list);
        System.out.println("Median is " +ans);
        
	}
	
	private static int countSmallerThanMid(ArrayList<Integer> row, int mid) {
        int l = 0, h = row.size() - 1; 
        while(l <= h) {
            int md = (l + h) >> 1; 
            if(row.get(md) <= mid) {
                l = md + 1;
            }
            else {
                h = md - 1;
            }
        }
        return l; 
    }
    public static int findMedian(ArrayList<ArrayList<Integer>> A) {
        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE; 
        int n = A.size();
        int m = A.get(0).size(); 
        while(low <= high) {
            int mid = (low + high) >> 1; 
            int cnt = 0;
            for(int i = 0;i<n;i++) {
                cnt += countSmallerThanMid(A.get(i), mid); 
            }
    
            if(cnt <= (n * m) / 2) low = mid + 1; 
            else high = mid - 1; 
        }
        return low; 
    }

}
