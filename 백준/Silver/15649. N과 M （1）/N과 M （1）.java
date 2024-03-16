import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static boolean[] visited;
	static int[] numbers;
	static int[] select;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		numbers = new int[N];
		select = new int[M];
		sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			numbers[i] = i + 1;
		}
		
		premutation(0);
		System.out.println(sb);
	}
	
	static void premutation(int idx) {
		// 기저 조건
		if (idx == M) {
			for (int i = 0; i < M - 1; i++) {
				sb.append(select[i] + " ");
			}
			sb.append(select[M - 1] + "\n");
			return;
		}
		
		// 재귀 조건
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				select[idx] = numbers[i];
				premutation(idx + 1);
				visited[i] = false;
			}
		}
	}
	
}