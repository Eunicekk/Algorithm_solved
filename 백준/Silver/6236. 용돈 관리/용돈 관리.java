import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] money = new int[N];
		
		int start = 0;
		int end = 0;
		
		for (int i = 0; i < N; i++) {
			money[i] = Integer.parseInt(br.readLine());
			start = Math.max(start, money[i]);
			end += money[i];
		}
		
		int sum = end;
		int result = 0;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			
			if (check(money, mid, M)) {
				result = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		System.out.println(result);
 	}
	
	static boolean check(int[] money, int amount, int M) {
		int count = 1;
		int sum = 0;
		
		for (int coin : money) {
			if (sum + coin > amount) {
				count++;
				sum = 0;
			}
			
			sum += coin;
		}
		
		return count <= M;
	}
	
}