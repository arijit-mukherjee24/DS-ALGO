package goldman_sachs;

// 91. Decode Ways
//Ref: https://www.youtube.com/watch?v=o1i7JYWbwOE Knowledge Center
public class DecodeWays {

	public static void main(String[] args) {
		
	}
	
	public int numDecodings(String s) {
        if(s==null || s.length()==0 || s.charAt(0)=='0')
            return 0;
        
        if(s.length()==1) return 1;
        
        int count1=1, count2=1;
        // starting from the 2nd char
        for(int i=1; i<s.length();i++) {
            //last digit
            int d=s.charAt(i) - '0';
            // last 2 digit
            int dd = (s.charAt(i-1) - '0')*10 + d;
            
            int count = 0;
            if(d > 0) count += count2;
            if(dd >= 10 && dd<=26) count += count1;
            
            count1 = count2; // prev to prev
            count2 = count;  // count2 prev soln
        }
        return count2;
    }

}

/*
Total Decoding Messages : GFG Practice (Not passed 1 test case)
- https://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
 
Code:-

public int CountWays(String str)
    {
        int n = str.length();
        if(str==null || n==0 || str.charAt(0)=='0')
            return 0;
            
        if(n==1) return 1;
        
        // A table to store results of subproblems
        int count[] = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        
        for (int i = 2; i <= n; i++)
        {
            count[i] = 0;
     
            // If the last digit is not 0,
            // then last digit must add to
            // the number of words
            if (str.charAt(i-1) > '0')
                count[i] = count[i - 1];
     
            // If second last digit is smaller
            // than 2 and last digit is smaller
            // than 7, then last two digits
            // form a valid character
            if (str.charAt(i-2) == '1' ||
               (str.charAt(i-2) == '2' &&
                str.charAt(i-1) < '7'))
                count[i] += count[i - 2];
        }
        return count[n];
    }

*/