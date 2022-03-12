package walmart;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 1383. Maximum Performance of a Team
//Ref: https://www.youtube.com/watch?v=V-TuDMMf-S4 CodingDecoded

//TC : O(nlogn)
//SC : O(n)
public class Q11_MaximumPerformanceOfATeam {

	public static void main(String[] args) {

	}

	public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
		List<Engineer> engineers = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			engineers.add(new Engineer(speed[i], efficiency[i]));
		}
		// now sort the engineers list by their efficiency descending
		engineers.sort((a, b) -> b.efficiency - a.efficiency);

		// will keep slowest members at the top, fastest ones stay in the team longest
		PriorityQueue<Engineer> currentTeam = new PriorityQueue<>((a, b) -> a.speed - b.speed);

		long teamSpeed = 0;
		long maxPerformance = 0;

		for (Engineer newHire : engineers) {

			if (currentTeam.size() == k) {

				// we must evict the slowest engineer from out current team

				Engineer slowGuy = currentTeam.poll();

				// now we must remove the slow guys speed from our total speed
				teamSpeed -= slowGuy.speed;
			}

			// hire the new guy to the team
			currentTeam.add(newHire);

			// so pickup the new engineers speed and add it to the current teams speed
			teamSpeed += newHire.speed;

			// Minimum would be new hire efficiency
			long performanceWithNewGuy = teamSpeed * (long) newHire.efficiency;
			maxPerformance = Math.max(maxPerformance, performanceWithNewGuy);
		}

		return (int) (maxPerformance % 1000000007);
	}
}

class Engineer {
	int speed;
	int efficiency;

	public Engineer(int speed, int efficiency) {
		this.speed = speed;
		this.efficiency = efficiency;
	}
}
