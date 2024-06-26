import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 구간 합 구하기 (5)
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 표의 크기
		int M = Integer.parseInt(st.nextToken()); // 합 구해야 하는 횟수
		
		int[][] array = new int[N+1][N+1];
		int[][] sum = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				sum[i][j] = array[i][j];
			}
		}
		
		// 행열 첫줄 초기화
		for (int i = 2; i <= N; i++) {
			sum[1][i] += sum[1][i-1];
			sum[i][1] += sum[i-1][1];
		}
		
		// 다른 부분 누적합
		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= N; j++) {
				sum[i][j] += sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int total = sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1-1];
			
			sb.append(total + "\n");
		}
		
		System.out.print(sb);
	}
	
}
