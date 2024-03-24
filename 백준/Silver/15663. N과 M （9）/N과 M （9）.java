import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// N과 M (9)
public class Main {
	
	static int N;
	static int M;
	static List<Integer> numbers = new ArrayList<Integer>();
	static int[] select;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		select = new int[M];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(numbers);
		permutation(0);
		System.out.println(sb);
	}
	
	static void permutation(int sidx) {
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
		
		for (int i = 0; i < N; i++) {
			if (!visited[i] && prev != numbers.get(i)) {
				visited[i] = true;
				select[sidx] = numbers.get(i);
				prev = select[sidx];
				permutation(sidx + 1);
				visited[i] = false;
			}
		}
	}
	
}