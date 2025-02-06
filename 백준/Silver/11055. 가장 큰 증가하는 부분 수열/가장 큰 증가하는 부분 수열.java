import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		int[] dp = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			dp[i] = array[i];
		}
		
		int max = dp[0];
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (array[j] < array[i]) {
					dp[i] = Math.max(dp[i], dp[j] + array[i]);
				}
			}
			
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
	
}