package softeer;

import java.util.*;
import java.io.*;

public class Main_바이러스 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		long mod = 1000000007;
		long virus = K;
		
		for (int i = 0; i < N; i++) {
			virus = (virus * P) % mod;
		}
		
		System.out.println(virus);
	}
	
}
