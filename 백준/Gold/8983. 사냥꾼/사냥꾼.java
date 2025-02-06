import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 사대의 수
		int N = Integer.parseInt(st.nextToken()); // 동물의 수
		int L = Integer.parseInt(st.nextToken()); // 사정거리
		
		int[] stand = new int[M];
		int count = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			stand[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(stand);
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if (canHunt(stand, x, y, L)) count++;
		}
		
		System.out.println(count);
	}
	
	static boolean canHunt(int[] stand, int x, int y, int L) {
		int left = 0;
		int right = stand.length - 1;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (Math.abs(stand[mid] - x) + y <= L) {
				return true;
			}
			
			if (stand[mid] < x) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return false;
	}
	
}