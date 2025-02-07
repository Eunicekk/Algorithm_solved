package softeer;

import java.util.*;
import java.io.*;

public class Main_전광판 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		Map<Character, String> lights = new HashMap<>();
		lights.put('0', "1110111");
        lights.put('1', "0010010");
        lights.put('2', "1011101");
        lights.put('3', "1011011");
        lights.put('4', "0111010");
        lights.put('5', "1101011");
        lights.put('6', "1101111");
        lights.put('7', "1110010");
        lights.put('8', "1111111");
        lights.put('9', "1111011");
        lights.put(' ', "0000000");
        
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int numB = Integer.parseInt(st.nextToken());
			int numA = Integer.parseInt(st.nextToken());

			String a = String.format("%5s", numA);
			String b = String.format("%5s", numB);
			char[] a_ = a.toCharArray();
			char[] b_ = b.toCharArray();
			
			int count = 0;
			
			for (int i = 0; i < 5; i++) {
				count += diff(lights.get(a_[i]), lights.get(b_[i]));
			}
			
			System.out.println(count);
		}
	}
	
	static int diff(String a, String b) {
		int count = 0;
		
		char[] a_ = a.toCharArray();
        char[] b_ = b.toCharArray();
        
        for (int i=0; i<a.length(); i++) {
            if (a_[i] != b_[i]) {
                count++;
            }
        }
        
        return count;
	}
	
}
