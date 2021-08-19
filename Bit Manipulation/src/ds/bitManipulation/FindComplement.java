package ds.bitManipulation;

public class FindComplement {

	public static void main(String[] args) {
		int i = 5;
		int ans = findComplement(i);
		System.out.println("The 1's complement of the number is " + ans);
	}

	private static int findComplement(int num) {
		if (num == 0)
			return 1;

		int result = 0;
		int i = 0;
		while (num != 0) {
			if ((num & 1) == 0) {
				result += (1 << i);
			}
			i++;
			num >>= 1;
		}
		return result;

	}

}
