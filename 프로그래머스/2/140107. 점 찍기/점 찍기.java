class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long length = (long) d * d;
        
        for (int r = 0; r <= d; r += k) {
            long nr = (long) r * r;
            if (length < nr) break;
            
            long nc = (long) length - nr;
            long c = (long) Math.sqrt(nc);
            answer += (c / k) + 1;
        }
        
        return answer;
    }
}