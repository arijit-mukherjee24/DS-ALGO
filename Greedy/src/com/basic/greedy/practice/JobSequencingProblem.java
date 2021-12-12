package com.basic.greedy.practice;

import java.util.Arrays;

// https://www.youtube.com/watch?v=LjPx4wQaRIs&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=48 
// https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
// Sort the job based on profit, and perform the job in the last date, so that job with minimum deadline can be performe

/*https://www.youtube.com/watch?v=LjPx4wQaRIs&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=48 
Sort the job based on profit, and perform the job in the last day, so that job with minimum deadline can be performed earlier
Take u forward
TC: O(nlogn + n*m)
nlogn -> sorting the job based on profit
n -> traversing all the job
m -> max deadline am0ng all jobs (may traversing the entire m range array for each job)
so, 2nd part=O(m*n)
*/
public class JobSequencingProblem {

	public static void main(String[] args) {

	}

	// Function to find the maximum profit and the number of jobs done.
	int[] JobScheduling(Job arr[], int n) {
		Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

		int maxi = 0;
		for (Job i : arr) {
			if (i.deadline > maxi)
				maxi = i.deadline;
		}

		int[] results = new int[maxi + 1];
		Arrays.fill(results, -1);

		int maxProfit = 0, countJob = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = arr[i].deadline; j > 0; j--) {
				if (results[j] == -1) {
					results[j] = arr[i].id;
					maxProfit += arr[i].profit;
					countJob++;
					break;
				}
			}
		}

		int[] ans = new int[2];
		ans[0] = countJob;
		ans[1] = maxProfit;

		return ans;
	}

}

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
