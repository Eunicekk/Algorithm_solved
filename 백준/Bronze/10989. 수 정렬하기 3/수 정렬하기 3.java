import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수 정렬하기 (3)
public class Main {
	
	static int[] array;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		array = new int[N];
		
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		radixSort(array, 5);
		
		for (int i = 0; i < N; i++) {
			sb.append(array[i] + "\n");
		}
		
		System.out.print(sb);
	}
	
	static void radixSort (int[] array, int max) {
		int[] output = new int[array.length];
		int j = 1;
		int count = 0;
		
		while (count != max) {
			int[] bucket = new int[10];
			
			for (int i = 0; i < array.length; i++) {
				bucket[(array[i] / j) % 10]++;
			}
			
			for (int i = 1; i < 10; i++) {
				bucket[i] += bucket[i - 1];
			}
			
			for (int i = array.length - 1; i >= 0; i--) {
				output[bucket[(array[i] / j % 10)] - 1] = array[i];
				bucket[(array[i] / j) % 10]--;
			}
			
			for (int i = 0; i < array.length; i++) {
				array[i] = output[i];
			}
			
			j *= 10;
			count++;
		}
	}
	
}
