import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] select;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		select = new int[M];
		
		powerset(0, 0);
		System.out.print(sb);
	}
	
	static void powerset(int idx, int sidx) {
		// 기저 조건
		if (sidx == M) {
			for (int i = 0; i < M-1; i++) {
				sb.append(select[i] + " ");
			}
			sb.append(select[M-1] + "\n");
			return;
		}
		
		// 재귀 조건
		for (int i = idx; i < N; i++) {
			select[sidx] = i + 1;
			powerset(i, sidx + 1);
		}
	}
	
}
