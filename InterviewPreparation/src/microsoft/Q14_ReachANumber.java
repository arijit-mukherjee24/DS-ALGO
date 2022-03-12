package microsoft;

// 754. Reach a Number
// Minimum steps to destination  Gfg

// Ref: https://www.youtube.com/watch?v=WJAA6jr8hMM Algorithms Made Easy
// https://leetcode.com/problems/reach-a-number/discuss/112968/Short-JAVA-Solution-with-Explanation Discussion 
public class Q14_ReachANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int minSteps(int target){
        target = Math.abs(target);
        int sum = 0, step = 0;
        
        while(sum < target) {
            step++;
            sum += step;
        }
        
        while((sum - target)%2 == 1) {
            step++;
            sum += step;
        } 
        
        return step;
    }

}
