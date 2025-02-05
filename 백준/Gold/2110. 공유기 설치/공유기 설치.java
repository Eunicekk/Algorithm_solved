import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] road = new int[N];
		
		for (int i = 0; i < N; i++) {
			road[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(road);
		
		int start = 1;
		int end = road[N-1] - road[0];
		int result = 0;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			int count = 1;
			int last = road[0];
			
			for (int i = 0; i < N; i++) {
				if (road[i] - last >= mid) {
					count++;
					last = road[i];
				}
			}
			
			if (count >= C) {
				result = mid;
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		System.out.println(result);
	}
	
}