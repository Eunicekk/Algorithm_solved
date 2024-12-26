import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        Map<Integer, int[]> keypad = new HashMap<>();
        keypad.put(1, new int[]{0, 0});
        keypad.put(2, new int[]{0, 1});
        keypad.put(3, new int[]{0, 2});
        keypad.put(4, new int[]{1, 0});
        keypad.put(5, new int[]{1, 1});
        keypad.put(6, new int[]{1, 2});
        keypad.put(7, new int[]{2, 0});
        keypad.put(8, new int[]{2, 1});
        keypad.put(9, new int[]{2, 2});
        keypad.put(-1, new int[]{3, 0});
        keypad.put(0, new int[]{3, 1});
        keypad.put(-2, new int[]{3, 2});
        
        int[] left = keypad.get(-1);
        int[] right = keypad.get(-2);
        
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                answer += "L";
                left = keypad.get(number);
            } else if (number == 3 || number == 6 || number == 9) {
                answer += "R";
                right = keypad.get(number);
            } else {
                int[] target = keypad.get(number);
                int leftHand = calculate(left, target);
                int rightHand = calculate(right, target);
                
                if (leftHand < rightHand || (leftHand == rightHand && hand.equals("left"))) {
                    answer += "L";
                    left = target;
                } else {
                    answer += "R";
                    right = target;
                }
            }
        }
        
        return answer.toString();
    }
    
    private int calculate(int[] start, int[] target) {
        return Math.abs(start[0] - target[0]) + Math.abs(start[1] - target[1]);
    }
}