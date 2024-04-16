import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수 정렬하기 (2)
public class Main {
	
	static int[] array;
	static int[] temp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		array = new int[N];
		temp = new int[N];
		
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		mergeSort(0, N-1);
		
		for (int i = 0; i < N; i++) {
			sb.append(array[i] + "\n");
		}
		
		System.out.print(sb);
	}
	
	static void mergeSort (int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(start, mid);
			mergeSort(mid+1, end);
			
			int p = start;
			int q = mid + 1;
			int idx = p;
			
			while (p <= mid || q <= end) {
				if (q > end || (p <= mid && array[p] < array[q])) {
					temp[idx++] = array[p++];
				} else {
					temp[idx++] = array[q++];
				}
			}
			
			for (int i = start; i <= end; i++) {
				array[i] = temp[i];
			}
		}
	}
	
}
