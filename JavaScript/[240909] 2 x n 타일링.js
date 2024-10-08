function solution(n) {
    let dp = [0, 1, 2];
    
    for (let i = 3; i <= n; i++) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
    }
    
    return dp[n];
}

// 정확성  테스트
// 테스트 1 〉	통과 (0.57ms, 33.4MB)
// 테스트 2 〉	통과 (0.15ms, 33.6MB)
// 테스트 3 〉	통과 (0.55ms, 33.7MB)
// 테스트 4 〉	통과 (2.36ms, 37MB)
// 테스트 5 〉	통과 (0.16ms, 33.6MB)
// 테스트 6 〉	통과 (0.72ms, 33.9MB)
// 테스트 7 〉	통과 (0.13ms, 33.6MB)
// 테스트 8 〉	통과 (0.56ms, 33.7MB)
// 테스트 9 〉	통과 (0.62ms, 33.8MB)
// 테스트 10 〉	통과 (2.64ms, 37MB)
// 테스트 11 〉	통과 (0.43ms, 33.6MB)
// 테스트 12 〉	통과 (0.25ms, 33.5MB)
// 테스트 13 〉	통과 (0.19ms, 33.6MB)
// 테스트 14 〉	통과 (0.43ms, 33.7MB)
// 효율성  테스트
// 테스트 1 〉	통과 (3.06ms, 37.1MB)
// 테스트 2 〉	통과 (3.28ms, 37.3MB)
// 테스트 3 〉	통과 (2.72ms, 37.1MB)
// 테스트 4 〉	통과 (2.34ms, 37MB)
// 테스트 5 〉	통과 (3.40ms, 37.8MB)
// 테스트 6 〉	통과 (2.92ms, 37.8MB)
