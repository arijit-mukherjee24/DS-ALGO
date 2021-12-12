package com.basic.greedy.practice;

import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
// https://takeuforward.org/interviews/strivers-sde-sheet-top-coding-interview-problems/

/*
Minimum Platforms 
Given arrival and departure times of all trains that reach a railway station. 
Find the minimum number of platforms required for the railway station so that no train is kept waiting.
Consider that all the trains arrive on the same day and leave on the same day. 
Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other. 
At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. 
In such cases, we need different platforms.


Example 1:

Input: n = 6 
arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
Output: 3
Explanation: 
Minimum 3 platforms are required to 
safely arrive and depart all trains.
Example 2:

Input: n = 3
arr[] = {0900, 1100, 1235}
dep[] = {1000, 1200, 1240}
Output: 1
Explanation: Only 1 platform is required to 
safely manage the arrival and departure 
of all trains.
*/

//https://www.youtube.com/watch?v=dxVcMDI7vyI&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=47
//Take u forward
//TC: O(2log(n) + 2n)  2logn -> Sorting two array, 2n-> traversing two array
//SC: O(1)
public class MinimumPlatforms {

	public static void main(String[] args) {
		
	}
	
	//Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
       Arrays.sort(arr);
       Arrays.sort(dep);
       
       int plat_need = 1, result = 1;
       int i = 1, j=0;
       
       while(i<n && j<n) {
           if(arr[i] <= dep[j]) {
               plat_need++;
               i++;
           }
           else if(arr[i] > dep[j]) {
               plat_need--;
               j++;
           }
           
           if(result < plat_need) {
               result = plat_need;
           }
       }
        return result;
    }

}


