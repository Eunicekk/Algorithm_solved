import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] note1 = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				note1[i] = Integer.parseInt(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine());
			int[] note2 = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				note2[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(note1);
			
			out: for (int i = 0; i < M; i++) {
				int start = 0;
				int end = N - 1;
				
				while (start <= end) {
					int mid = (start + end) / 2;
					
					if (note1[mid] == note2[i]) {
						sb.append(1 + "\n");
						continue out;
					} else if (note1[mid] > note2[i]) {
						end = mid - 1;
					} else if (note1[mid] < note2[i]) {
						start = mid + 1;
					}
				}
				
				sb.append(0 + "\n");
			}
		}
		
		System.out.print(sb);
	}
	
}