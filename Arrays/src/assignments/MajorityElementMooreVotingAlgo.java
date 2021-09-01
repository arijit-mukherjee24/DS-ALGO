package assignments;

// https://www.youtube.com/watch?v=n5QY3x_GNDg (techdose)
// https://gist.github.com/SuryaPratapK/e53c468c3f6cc6b804f7b71d16928605
public class MajorityElementMooreVotingAlgo {

	public static void main(String[] args) {
		int arr[] = { 2, 2, 1, 1, 1, 2, 2 };
		int candidate = findCandidate(arr);

		boolean isMajority = isMajority(arr, candidate);

		if (isMajority)
			System.out.println("The majority element is " + candidate);
	}

	private static boolean isMajority(int[] arr, int candidate) {

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (candidate == arr[i]) {
				count++;
			}
		}

		if (count > arr.length / 2)
			return true;

		return false;
	}

	private static int findCandidate(int[] arr) {

		int majorityIndex = 0;
		int count = 1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[majorityIndex] == arr[i]) {
				count++;
			} else {
				count--;
			}

			if (count == 0) {
				majorityIndex = i;
				count = 1;
			}
		}

		return arr[majorityIndex];
	}

}
