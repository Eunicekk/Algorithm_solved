import java.util.*;
import java.math.*;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        BigInteger N = BigInteger.valueOf(n);
        BigInteger M = BigInteger.valueOf(m);
        BigInteger gcd = N.gcd(M);
        BigInteger lcm = (N.multiply(M)).divide(gcd);
        
        answer[0] = gcd.intValue();
        answer[1] = lcm.intValue();
        
        return answer;
    }
}