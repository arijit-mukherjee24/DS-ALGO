package ds.bitManipulation;

public class ToggleCase {

	public static void main(String[] args) {
		String s = "CheRRy";
		String ans =  toggleCase(s.toCharArray());
		System.out.println("The toggled string is "+ans);
	}

	private static String toggleCase(char[] charArray) {
		for(int i= 0; i< charArray.length; i++) {
			charArray[i] ^= 32;
		}
		return new String(charArray);
	}

}
