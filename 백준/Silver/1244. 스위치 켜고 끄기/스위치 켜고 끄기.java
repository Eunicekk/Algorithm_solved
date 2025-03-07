import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] button = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			button[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			
			if (gender == 1) {
				for (int j = 1; j <= N; j++) {
					if (j % number == 0) {
						button[j] = button[j] == 0 ? 1 : 0;
					}
				}
			} else {
				button[number] = button[number] == 0 ? 1 : 0;
				
				for (int j = 1; number - j >= 1 && number + j <= N; j++) {
					if (button[number - j] == button[number + j]) {
						button[number - j] = button[number - j] == 0 ? 1 : 0;
						button[number + j] = button[number + j] == 0 ? 1 : 0;
					} else {
						break;
					}
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(button[i] + " ");
			if (i % 20 == 0) sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
}