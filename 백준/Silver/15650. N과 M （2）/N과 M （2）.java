import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] nums;
	static int[] select;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		select = new int[M];
		sb = new StringBuilder();
		
		for (int i = 1; i <= N; i++) {
			nums[i - 1] = i;
		}
		
		combination(0, 0);
		System.out.println(sb);
	}
	
	static void combination(int index, int sindex) {
		// 기저 조건
		if (sindex == M) {
			for (int i = 0; i < M-1; i++) {
				sb.append(select[i] + " ");
			}
			sb.append(select[M-1] + "\n");
			
			return;
		}
		
		if (index == N) {
			return;
		}
		
		
		// 재귀 부분
		select[sindex] = nums[index];
		combination(index + 1, sindex + 1);
		combination(index + 1, sindex);
	}
	
}