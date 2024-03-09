import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 최댓값
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[9];
		int max = Integer.MIN_VALUE;
		int index = 0;
		
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < 9; i++) {
			max = Math.max(max, arr[i]);
			if (max == arr[i]) {
				index = i + 1;
			}
		}
		
		bw.write(max + "\n");
		bw.write(String.format("%d", index));
		bw.close();
	}
	
}
