package softeer;

import java.util.*;
import java.io.*;

public class Main_징검다리 {
	
	static int N;
	static int[] bridge;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		bridge = new int[N];
		dp = new int[N];
		int max = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			bridge[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			
			for (int j = 0; j < i; j++) {
				if (bridge[j] < bridge[i]) {
					dp[i] = Math.max(dp[i],	dp[j] + 1);
				}
			}
			
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		
	}
	
}
