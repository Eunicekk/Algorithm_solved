import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		int start = 1;
		int end = V;
		int result = V;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			long climb = (long) (mid - 1) * (A - B) + A;
			
			if (climb >= V) {
				result = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		System.out.println(result);
	}
	
}