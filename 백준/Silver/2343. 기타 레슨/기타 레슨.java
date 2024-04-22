import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] lesson = new int[N];
		
		int left = 0;
		int right = 0;
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			lesson[i] = Integer.parseInt(st.nextToken());
			right += lesson[i];
			left = Math.max(left, lesson[i]);
		}
		
		while (left <= right) {
			int mid = (left + right) / 2;
			int count = getCount(N, lesson, mid);
			
			if (count > M) left = mid + 1;
			else right = mid - 1;
		}
		
		System.out.println(left);
	}
	
	static int getCount(int N, int[] lesson, int mid) {
		int sum = 0;
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (sum + lesson[i] > mid) {
				sum = 0;
				count++;
			}
			sum += lesson[i];
		}
		
		if (sum != 0) count++;
		return count;
	}
	
}