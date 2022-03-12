package walmart;

public class Q8_MaximumHeightTree {

	public static void main(String[] args) {
		
	}
	
	static int height(int N){
        int i=0;
        for(;i<1000;i++) {
            if(((i*(i+1))/2)>N)
                break;
        }
        return i-1;
    }

}
