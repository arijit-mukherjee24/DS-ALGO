package ds.bitManipulation;

public class LargestPowerOfTwo {

	public static void main(String[] args) {
		int num = 10;
		int ans = highestPowerOfTwo(num);
		System.out.println("Highest power value of 2 is " + ans);

	}

	private static int highestPowerOfTwo(int num) {
		while ((num & (num - 1)) != 0) {
			num = num & (num - 1);
		}
		return num;
	}

}
