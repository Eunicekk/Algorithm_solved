import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 과제 안 내신 분..?
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] students = new int[31];
		
		for (int i = 0; i < 28; i++) {
			int num = Integer.parseInt(br.readLine());
			students[num]++;
		}
		
		for (int i = 1; i < students.length; i++) {
			if (students[i] == 0) {
				bw.write(i + "\n");
			}
		}
		
		bw.close();
	}
	
}