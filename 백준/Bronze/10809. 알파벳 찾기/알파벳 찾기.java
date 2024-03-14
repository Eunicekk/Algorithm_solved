import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 알파벳 찾기
public class Main {
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 
		 String str = br.readLine();
		 
		 int[] alphabet = new int[26];
		 
		 for (int i = 0; i < alphabet.length; i++) {
			 alphabet[i] = -1;
		 }
		 
		 for (int i = 0; i < str.length(); i++) {
			 if (alphabet[str.charAt(i) - 97] == -1) {
				 alphabet[str.charAt(i) - 97] = i;
			 }
		 }
		 
		 for (int i = 0; i < alphabet.length; i++) {
			 bw.write(alphabet[i] + " ");
		 }
		 bw.close();
	}
	
}