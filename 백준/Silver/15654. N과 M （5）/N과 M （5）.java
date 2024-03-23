import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M (5)
public class Main {
	
	static int N;
	static int M;
	static int[] nums;
	static int[] select;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		select = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(nums);
		permutation(0);
		
		System.out.println(sb);
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
			if (!visited[i]) {
				visited[i] = true;
				select[idx] = nums[i];
				permutation(idx + 1);
				visited[i] = false;
			}
		}
		
	}
	
}