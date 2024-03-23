class Solution {
    public int[] solution(long n) {
        String temp = String.valueOf(n);
        int[] answer = new int[temp.length()];
        
        for (int i = temp.length() - 1; i >= 0; i--) {
            answer[temp.length() - 1 - i] = temp.charAt(i) - '0';
        }
        
        return answer;
    }
}