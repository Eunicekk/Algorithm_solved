import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// K번째 수
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] array = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		quickSort(array, 0, N-1);
		System.out.println(array[K-1]);
	}
	
	static void quickSort (int[] array, int start, int end) {
		int part = partition(array, start, end);
		
		if (start < part - 1) {
			quickSort(array, start, part - 1);
		}
		
		if (part < end) {
			quickSort(array, part, end);
		}
	}
	
	static int partition (int[] array, int start, int end) {
		int mid = (start + end) / 2;
		int pivot = array[mid];
		
		while (start <= end) {
			while (array[start] < pivot) start++;
			while (array[end] > pivot) end--;
			
			if (start <= end) {
				swap(array, start, end);
				start++;
				end--;
			}
		}
		
		return start;
	}
	
	static void swap (int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
}
