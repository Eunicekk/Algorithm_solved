import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 배수 스위치
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] light = br.readLine().toCharArray();
		int count = 0;
		
		for (int i = 0; i < light.length; i++) {
			if (light[i] == 'Y') {
				for (int j = 0; j < light.length; j++) {
					if ((j + 1) % (i + 1) == 0) {
						if (light[j] == 'Y') {
							light[j] = 'N';
						} else {
							light[j] = 'Y';
						}
					}
				}
				
				count++;
			} else {
				continue;
			}
		}
		
		bw.write(count + "");
		bw.close();
	}
	
}