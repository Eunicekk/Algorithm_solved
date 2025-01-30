import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][N];
			int[][] dp = new int[2][N];
			
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			
			dp[0][0] = sticker[0][0];
			dp[1][0] = sticker[1][0];
			
			if (N > 1) {
				dp[0][1] = sticker[0][1] + dp[1][0];
				dp[1][1] = sticker[1][1] + dp[0][0];
			}
			
			for (int i = 2; i < N; i++) {
				dp[0][i] = sticker[0][i] + Math.max(dp[1][i-1], dp[1][i-2]);
				dp[1][i] = sticker[1][i] + Math.max(dp[0][i-1], dp[0][i-2]);
			}
			
			System.out.println(Math.max(dp[0][N-1], dp[1][N-1]));
		}
	}
	
}