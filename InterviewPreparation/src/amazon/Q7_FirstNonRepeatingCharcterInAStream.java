package amazon;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=gbASJJAvAGk Code Library
public class Q7_FirstNonRepeatingCharcterInAStream {

	public static void main(String[] args) {
		
	}
	
	public String FirstNonRepeating(String s)
    {
        int[] freq = new int[26];
        List<Character> order = new ArrayList<>();
        int n = s.length();
        StringBuffer sb = new StringBuffer();
        
        for(int i=0; i<n; i++) {
            if(freq[s.charAt(i) - 'a'] == 0) {
                order.add(s.charAt(i));
            }
            freq[s.charAt(i) - 'a']++;
            boolean found = false;
            for(int j=0; j<order.size(); j++) {
                if(freq[order.get(j) -'a'] == 1) {
                    sb.append(order.get(j));
                    found = true;
                    break;
                }
            }
            
            if(!found) sb.append('#');
        }
        
        return sb.toString();
    }

}
