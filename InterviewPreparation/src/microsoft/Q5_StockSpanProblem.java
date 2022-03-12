package microsoft;

import java.util.Arrays;
import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1

//https://github.com/arijit-mukherjee24/DS-ALGO/blob/c1243f4adcff03711d4ee7f657cafb918dc01298/Stack/src/com/dsa/stack/StockSpanProblem.java
//https://www.youtube.com/watch?v=p9T-fE1g1pU&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=6 Aditya Verma
//https://www.techiedelight.com/next-greater-element/ 3rd approach


public class Q5_StockSpanProblem {
	
	//Function to calculate the span of stock’s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        
        int[] res = new int[n];
        Arrays.fill(res, -1);
        
        for(int i=0; i<n; i++) {
            while(!stack.isEmpty()) {
                if(stack.peek() <= price[i]) {
                    stack.pop();
                    indexStack.pop();
                }
                else {
                    res[i] = indexStack.peek(); // index - ngl_index
                    break;
                }
            }
            
            stack.push(price[i]);
            indexStack.push(i);
        }
        
        for(int i =0; i<n; i++) {
            res[i] = i - res[i];
        }
        
        return res;
    }
}
