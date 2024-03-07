import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 단어 공부
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int[] alphabet = new int[26];

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 97) {
				alphabet[str.charAt(i) - 97]++;
			} else {
				alphabet[str.charAt(i) - 65]++;
			}
		}
		
		int max = Integer.MIN_VALUE;
		int index = 0;
		int count = 0;
		
		for (int i = 0; i < alphabet.length; i++) {
			max = Math.max(max, alphabet[i]);
		}
		
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] == max) {
				count++;
				index = i;
			}
		}
		
		if (count > 1) {
			bw.write("?");
		} else {
			bw.write(String.format("%c", index + 65));
		}
		bw.close();
	}
	
}