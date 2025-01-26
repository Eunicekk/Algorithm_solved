import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] friend = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			Arrays.fill(friend[i], 10_000_000);
			friend[i][i] = 0;
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friend[a][b] = 1;
			friend[b][a] = 1;
		}
		
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (friend[i][j] > friend[i][k] + friend[k][j]) {
						friend[i][j] = friend[i][k] + friend[k][j];
					}
				}
			}
		}
		
		int minNode = 1;
		int minSum = Integer.MAX_VALUE;
		
		for (int i = 1; i <= N; i++) {
			int sum = 0;
			
			for (int j = 1; j <= N; j++) {
				sum += friend[i][j];
			}
			
			if (sum < minSum) {
				minSum = sum;
				minNode = i;
			}
		}
		
		System.out.println(minNode);
	}
	
}