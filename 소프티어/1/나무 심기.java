package softeer;

import java.util.*;
import java.io.*;

public class Main_나무심기 {

	static int N;
	static boolean[] visit;
	static int[] tree;
	static int[] select;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new int[N];
		visit = new boolean[N];
		select = new int[2];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		permutation(0);
		
		System.out.println(max);
	}
	
	static void permutation(int idx) {
		if (idx == 2) {
			max = Math.max(max, select[0] * select[1]);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				select[idx] = tree[i];
				permutation(idx + 1);
				visit[i] = false;
			}
		}
	}
}
