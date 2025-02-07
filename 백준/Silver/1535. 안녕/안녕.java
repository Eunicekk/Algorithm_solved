import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] energy = new int[N];
		int[] happy = new int[N];
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			energy[i] = Integer.parseInt(st1.nextToken());
			happy[i] = Integer.parseInt(st2.nextToken());
		}
		
		int[] dp = new int[101];
		
		for (int i = 0; i < N; i++) {
			for (int j = 100; j >= energy[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - energy[i]] + happy[i]);
			}
		}
		
		System.out.println(dp[99]);
	}
	
}