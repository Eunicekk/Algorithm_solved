import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (4)
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
		
		for (int i = 0; i < N; i++) {
			nums[i] = i + 1;
		}
		
		combination(0, 0);
		System.out.println(sb);
	}
	
	static void combination(int index, int sindex) {
		// 기저 조건
		if (sindex >= M) {
			for (int i = 0; i < M-1; i++) {
				sb.append(select[i] + " ");
			}
			sb.append(select[M-1] + "\n");
			
			return;
		}

		// 재귀 부분
		for (int i = index; i < N; i++) {
			select[sindex] = nums[i];
			combination(i, sindex + 1);
		}
	}
	
}