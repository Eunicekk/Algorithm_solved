import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] last = new int[42];
		int count = 0;
		
		for (int i = 0; i < 10; i++) {
			int num = Integer.parseInt(br.readLine());
			
			for (int j = 0; j < last.length; j++) {
				if (num % 42 == j) {
					last[j]++;
				}
			}
		}
		
		for (int i = 0; i < last.length; i++) {
			if (last[i] != 0) {
				count++;
			}
		}
		
		bw.write(String.format("%d", count));
		bw.close();
	}
	
}