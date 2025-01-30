import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] lights = new int[M];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			lights[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 1;
		int end = N;
		int result = N;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			
			if (checkLight(lights, N, mid)) {
				result = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		System.out.println(result);
	}
	
	static boolean checkLight(int[] lights, int N, int H) {
		int cover = 0;
		
		for (int light : lights) {
			if (cover < light - H) return false;
			cover = light + H;
		}
		
		return cover >= N;
	}
	
}