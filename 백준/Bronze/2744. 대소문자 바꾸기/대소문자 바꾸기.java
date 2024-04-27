import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 대소문자 바꾸기
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		String answer = "";
		
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) >= 97) {
				answer += (char)(word.charAt(i) - 32);
			} else {
				answer += (char)(word.charAt(i) + 32);
			}
		}
		
		System.out.println(answer);
	}
	
}
