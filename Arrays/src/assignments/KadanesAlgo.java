package assignments;

// Ref: https://www.youtube.com/watch?v=YxuK6A3SvTs (Techdose)
public class KadanesAlgo {

	// worked for -ve and +ve integers
	public static void main(String[] args) {
		int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
	}

	private static int maxSubArraySum(int[] a) {

		int meh = 0;
		int msf = Integer.MIN_VALUE;

		for (int i = 0; i < a.length; i++) {
			meh = meh + a[i];
			if (meh < a[i]) {
				meh = a[i];
			}

			if (msf < meh) {
				msf = meh;
			}

		}
		return msf;
	}

}
