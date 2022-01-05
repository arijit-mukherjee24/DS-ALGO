package goldman_sachs;

// https://leetcode.com/discuss/interview-experience/514986/Goldman-Sachs-Interview-Process-and-Questions (First comment)
import java.util.PriorityQueue;

public class Max10in10MEntries {

	static PriorityQueue<Integer> pq = new PriorityQueue<>(10);

	public static void main(String[] args) {
		insertNum(5);insertNum(1);insertNum(21);
		insertNum(12);insertNum(11);insertNum(20);
		insertNum(2);insertNum(8);insertNum(14);
		insertNum(7);insertNum(9);insertNum(15);
		insertNum(3);insertNum(10);insertNum(6);
		insertNum(19);insertNum(17);insertNum(16);
		insertNum(4);insertNum(18);insertNum(13);
		
		System.out.println("Size "+ pq.size());
		while(pq.size() > 0) {
			System.out.print(pq.poll() + " ");
		}
	}
	
	private static void insertNum(int num) {
		if (pq.size() < 10) {
			pq.add(num);
			return;
		}

		if (num > pq.peek()) {
			pq.poll();
			pq.add(num);
		}
	}

}
