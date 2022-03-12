package adobe;

// https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1/ gfg practice
import java.util.ArrayList;

public class Q12_LeadersInArray {

	public static void main(String[] args) {

	}

	// Function to find the leaders in the array.
	static ArrayList<Integer> leaders(int arr[], int n) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0, arr[n - 1]);

		int highestSoFar = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] >= highestSoFar) {
				list.add(0, arr[i]);
				highestSoFar = arr[i];
			}
		}

		return list;
	}

}
