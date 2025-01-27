import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] lesson = new int[N];
		
		int max = 0;
		int sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			lesson[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, lesson[i]);
			sum += lesson[i];
		}
		
		int low = max;
		int high = sum;
		int result = high;
		
		while (low <= high) {
			int mid = (low + high) / 2;
			
			if (divide(lesson, M, mid)) {
				result = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		System.out.println(result);
	}
	
	static boolean divide(int[] lesson, int M, int size) {
		int count = 1;
		int sum = 0;
		
		for (int les : lesson) {
			if (sum + les > size) {
				count++;
				sum = les;
			} else {
				sum += les;
			}
		}
		
		return count <= M;
	}
	
}