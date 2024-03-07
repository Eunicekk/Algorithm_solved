import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 단어의 개수
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		String[] array = str.split(" ");
		int length = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] != "") {
				length++;
			}
		}
		
		bw.write(String.format("%d", length));
		bw.close();
	}
	
}