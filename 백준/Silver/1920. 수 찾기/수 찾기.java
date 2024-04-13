import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 수 찾기
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < M; i++) {
			if (binarySearch(arr, Integer.parseInt(st.nextToken())) >= 0) {
				sb.append(1 + "\n");
			} else {
				sb.append(0 + "\n");
			}
		}
		
		System.out.print(sb);
	}
	
	static int binarySearch (int[] arr, int key) {
		int left = 0; // 왼쪽 인덱스
		int right = arr.length - 1; // 오른쪽 인덱스
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			if (key < arr[mid]) {
				right = mid - 1;
			} else if (key > arr[mid]) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		
		return -1;
	}
	
}
