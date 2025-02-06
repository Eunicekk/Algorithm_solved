import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 입국심사대 개수
		int M = Integer.parseInt(st.nextToken()); // 친구들 수
		int[] times = new int[N];
		
		for (int i = 0; i < N; i++) {
			times[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(times);
		
		long start = 1;
		long end = (long) times[N-1] * M;
		long result = end;
		
		while (start <= end) {
			long mid = (start + end) / 2;
			long count = 0;
			
			for (int time : times) {
				count += mid / time;
				if (count >= M) break;
			}
			
			if (count >= M) {
				result = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		System.out.println(result);
	}
	
}