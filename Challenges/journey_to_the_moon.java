import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = bfr.readLine().split(" ");
		int N = Integer.parseInt(temp[0]);
		int I = Integer.parseInt(temp[1]);
		UnionFind UF = new UnionFind(N);

		for (int i = 0; i < I; i++) {
			temp = bfr.readLine().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			UF.unionSet(a, b);
		}

		Vector<Integer> uniqueSets = new Vector<Integer>();
		for (int i = 0; i < N; i++) {
			if (!uniqueSets.contains(UF.findSet(i)))
				uniqueSets.add(UF.findSet(i));
		}

		long combinations = 0;
		combinations = getAstronautCombinations(UF, uniqueSets);
		System.out.println(combinations);
	}

	private static long getAstronautCombinations(UnionFind uF,
			Vector<Integer> uniqueSets) {
		long combinations = 0;

		for (int i = 0; i < uniqueSets.size(); i++) {
			for (int j = i + 1; j < uniqueSets.size(); j++) {
				combinations += uF.sizeOfSet(uniqueSets.get(i))
						* uF.sizeOfSet(uniqueSets.get(j));
			}
		}
		return combinations;
	}
}

class UnionFind {
	private Vector<Integer> p, rank, setSize;
	private int numSets;

	public UnionFind(int N) {
		p = new Vector<Integer>(N);
		rank = new Vector<Integer>(N);
		setSize = new Vector<Integer>(N);
		numSets = N;
		for (int i = 0; i < N; i++) {
			p.add(i);
			rank.add(0);
			setSize.add(1);
		}
	}

	public int findSet(int i) {
		if (p.get(i) == i)
			return i;
		else {
			int ret = findSet(p.get(i));
			p.set(i, ret);
			return ret;
		}
	}

	public Boolean isSameSet(int i, int j) {
		return findSet(i) == findSet(j);
	}

	public void unionSet(int i, int j) {
		if (!isSameSet(i, j)) {
			numSets--;
			int x = findSet(i), y = findSet(j);
			if (rank.get(x) > rank.get(y)) {
				p.set(y, x);
				setSize.set(x, setSize.get(x) + setSize.get(y));
			} else {
				p.set(x, y);
				setSize.set(y, setSize.get(y) + setSize.get(x));
				if (rank.get(x) == rank.get(y))
					rank.set(y, rank.get(y) + 1);
			}
		}
	}

	public int numDisjointSets() {
		return numSets;
	}

	public int sizeOfSet(int i) {
		return setSize.get(findSet(i));
	}
}