import java.util.Scanner;
import java.util.Vector;
import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int numOfInputs = stdin.nextInt();
		Vector<Integer[]> inputs = new Vector<Integer[]>();

		for (int i = 0; i < numOfInputs; i++) {
			int numOfVals = stdin.nextInt();
			Integer[] inputArr = new Integer[numOfVals];
			for (int j = 0; j < numOfVals; j++) {
				inputArr[j] = stdin.nextInt();
			}
			inputs.add(inputArr);
		}

		for (Integer[] input : inputs) {
			if (isWatsonArray(input))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	private static Boolean isWatsonArray(Integer[] input) {
		int[] forwardSum = new int[input.length];
		forwardSum[0] = input[0];
		int[] backwardSum = new int[input.length];
		backwardSum[input.length - 1] = input[input.length - 1];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, forwardSum[0]);

		for (int i = 1; i < input.length; i++) {
			forwardSum[i] = input[i] + forwardSum[i - 1];
			map.put(i, forwardSum[i]);
		}
        if (map.get(input.length - 1) == backwardSum[input.length - 1])
			return true;
		for (int i = input.length - 2; i >= 0; i--) {
			backwardSum[i] = input[i] + backwardSum[i + 1];
			if (map.get(i) == backwardSum[i])
				return true;
		}

		return false;
	}

}