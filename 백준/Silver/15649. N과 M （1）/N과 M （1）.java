import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M(1)
public class Main {
	
	static int N;
	static int M;
	static boolean[] visit;
	static int[] select;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N];
		select = new int[M];
		
		permutation(0);
		System.out.print(sb);
	}
	
	static void permutation(int idx) {
		// 기저 조건
		if (idx == M) {
			for (int i = 0; i < M-1; i++) {
				sb.append(select[i] + " ");
			}
			sb.append(select[M-1] + "\n");
			return;
		}
		
		// 재귀 조건
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				select[idx] = i + 1;
				permutation(idx + 1);
				visit[i] = false;
			}
		}
	}
}
