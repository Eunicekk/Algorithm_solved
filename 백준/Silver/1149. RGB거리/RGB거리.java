import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// RGB거리
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][3];
		int[][] rgb = new int[N+1][3];
		int min = Integer.MAX_VALUE;
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			rgb[i][0] = Integer.parseInt(st.nextToken());
			rgb[i][1] = Integer.parseInt(st.nextToken());
			rgb[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < 3; i++) {
			dp[1][i] = rgb[1][i];
		}
		
		for (int i = 2; i <= N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + rgb[i][2];
		}
		
		for (int i = 0; i < 3; i++) {
			min = Math.min(min, dp[N][i]);
		}
		
		System.out.println(min);
	}
	
}
