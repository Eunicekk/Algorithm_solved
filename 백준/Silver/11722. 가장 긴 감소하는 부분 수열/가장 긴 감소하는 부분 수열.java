import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		List<Integer> lds = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int num : numbers) {
			int idx = Collections.binarySearch(lds, num, Collections.reverseOrder());
			if (idx < 0) idx = -(idx + 1);
			
			if (idx == lds.size()) {
				lds.add(num);
			} else {
				lds.set(idx, num);
			}
		}
		
		System.out.println(lds.size());
	}
	
}