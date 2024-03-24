import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//N과 M (12)
public class Main {
	
	static int N;
	static int M;
	static int[] numbers;
	static int[] select;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		select = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		combination(0, 0);
		System.out.println(sb);
	}
	
	static void combination(int idx, int sidx) {
		// 기저 조건
		if (sidx == M) {
			for (int i = 0; i < M-1; i++) {
				sb.append(select[i] + " ");
			}
			sb.append(select[M-1] + "\n");
			return;
		}
		
		// 재귀 부분
		int prev = -1;
		for (int i = idx; i < N; i++) {
			if (prev != numbers[i]) {
				select[sidx] = numbers[i];
				combination(i, sidx + 1);
				prev = numbers[i];
			}
		}
	}
	
}
