import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Solution {
	private int[] A;
	private int P, Q;
	private Vector<Integer> V;

	public static void main(String[] args) {
		Solution sherlock = new Solution();
		sherlock.run();
	}

	private void run() {
		readInput();
		System.out.print(sherlockMiniMax());
	}

	private Boolean valid(int val) {
		if (P <= val && val <= Q)
			return true;
		return false;
	}

	private int sherlockMiniMax() {
		for (int i = 0; i < A.length - 1; i++) {
			int diff = A[i + 1] - A[i];
			if (valid(A[i] + diff / 2))
				V.add(A[i] + diff / 2);
			if (valid(A[i + 1] - diff / 2))
				V.add(A[i + 1] - diff / 2);
		}
		V.add(P);
		V.add(Q);
		Collections.sort(V);
		int best = -1;
		int bestVal = 0;

		for (int i = 0; i < V.size(); i++) {
			int val = Integer.MAX_VALUE;
			for (int j = 0; j < A.length; j++)
				if (Math.abs(A[j] - V.get(i)) < val)
					val = Math.abs(A[j] - V.get(i));
			if (val > best) {
				best = val;
				bestVal = V.get(i);
			}
		}
		return bestVal;
	}

	private void readInput() {
		Scanner stdin = new Scanner(System.in);
		int num = stdin.nextInt();
		A = new int[num];
		V = new Vector<Integer>();
		for (int i = 0; i < num; i++)
			A[i] = stdin.nextInt();
		Arrays.sort(A);
		P = stdin.nextInt();
		Q = stdin.nextInt();
	}
}