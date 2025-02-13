import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int count;
	static boolean[] visit1, visit2, visit3;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visit1 = new boolean[N];
		visit2 = new boolean[N*2];
		visit3 = new boolean[N*2];
		
		backtrack(0);
		System.out.println(count);
	}
	
	static void backtrack(int r) {
		if (r == N) {
			count++;
			return;
		}
		
		for (int c = 0; c < N; c++) {
			if (visit1[c] || visit2[r + c] || visit3[r-c+N]) continue;
			
			visit1[c] = visit2[r + c] = visit3[r-c+N] = true;
			backtrack(r + 1);
			visit1[c] = visit2[r + c] = visit3[r-c+N] = false;
		}
	}
	
}