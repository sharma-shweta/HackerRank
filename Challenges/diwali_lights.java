import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int numOfBulbs = stdin.nextInt();
		for (int i = 0; i < numOfBulbs; i++)
			System.out.println(getNumOfCombinations(stdin.nextInt()));
	}

	private static BigInteger getNumOfCombinations(int numOfBulbs) {
		BigInteger bigNumOfBulbs = new BigInteger(new Integer(2).toString());
		return bigNumOfBulbs.pow(numOfBulbs)
				.subtract(new BigInteger(new Integer(1).toString()))
				.mod(new BigInteger(new Integer(100000).toString()));
	}
}