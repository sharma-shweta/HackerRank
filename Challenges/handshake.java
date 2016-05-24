import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int numOfHandshakes = stdin.nextInt();
		for (int i = 0; i < numOfHandshakes; i++)
			System.out.println(getNumOfHandshakes(stdin.nextInt()));
	}

	private static int getNumOfHandshakes(int numOfHandshakes) {
		return (numOfHandshakes * (numOfHandshakes - 1)) / 2;
	}
}