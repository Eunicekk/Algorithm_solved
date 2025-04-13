import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		if (nextPermutation(array)) {
			for (int i = 0; i < N-1; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.print(array[N-1]);
		} else {
			System.out.println("-1");
		}
	}
	
	static boolean nextPermutation (int[] array) {
		int i = array.length - 1;
		while (i > 0 && array[i - 1] >= array[i]) {
			i--;
		}
		
		if (i <= 0) return false;
		
		int j = array.length - 1;
		while (array[j] <= array[i - 1]) {
			j--;
		}
		
		swap(array, i - 1, j);
		Arrays.sort(array, i, array.length);
		return true;
	}
	
	static void swap (int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
}
