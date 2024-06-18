import java.util.*;

// class Solution {
//     static String answer = "";
    
//     public String solution(String number, int k) {
//         StringBuilder sb = new StringBuilder();
//         combination(number, k, sb, 0);
//         return answer;
//     }
    
//     static void combination(String number, int k, StringBuilder sb, int idx) {
//         // 기저 조건
//         if (sb.length() + (number.length() - idx) < number.length() - k) {
//             return;
//         }
        
//         if (sb.length() == number.length() - k) {
//             String result = sb.toString();
//             if (result.compareTo(answer) > 0) {
//                 answer = result;
//             }
            
//             return;
//         }
        
//         // 재귀 부분
//         sb.append(number.charAt(idx));
//         combination(number, k, sb, idx + 1);
//         sb.deleteCharAt(sb.length() - 1);
//         combination(number, k, sb, idx + 1);
//     }
// }

class Solution {
    public String solution(String number, int k) {
        int length = number.length() - k;
        char[] result = new char[length];
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < current && k > 0) {
                stack.pop();
                k--;
            }
            
            stack.push(current);
        }
        
        for (int i = 0; i < length; i++) {
            result[i] = stack.get(i);
        }

        return new String(result);
    }
}