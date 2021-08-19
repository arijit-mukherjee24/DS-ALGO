package ds.bitManipulation;

public class LargestPowerOfTwo2 {

	public static void main(String[] args) {
		int num = 10;
		int ans = highestPowerOfTwo(num);
		System.out.println("Highest power value of 2 is " + ans);

	}

	private static int highestPowerOfTwo(int num) {
		if(num < 1) {
			return 0;
		}
		int ans, cal;
		ans = cal = 1;
		
		while(cal <= num) {
			cal = ans << 1;
			if(cal <= num) {
				ans = cal;
			}
		}
		return ans;
	}

}
