import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 그룹 단어 체커
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			int[] alphabet = new int[26];
			int sum = 0;
			
			for (int i = 0; i < str.length(); i++) {
				if (alphabet[str.charAt(i) - 97] == 0) {
					alphabet[str.charAt(i) - 97]++;
				} else {
					if (str.charAt(i) == str.charAt(i - 1)) {
						alphabet[str.charAt(i) - 97]++;
					}
				}
			}
			
			for (int i = 0; i < alphabet.length; i++) {
				sum += alphabet[i];
			}
			
			if (sum == str.length()) {
				count++;
			}
			
		}
		
		bw.write(count + "");
		bw.close();
	}
	
}