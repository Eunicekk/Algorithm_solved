function solution(slice, n) {
    var answer = slice;
    
    while (true) {
        if (answer / n >= 1) {
            return parseInt(answer / slice);
        } else {
            answer += slice;
        }
    }
}

// 테스트 1 〉	통과 (0.03ms, 33.4MB)
// 테스트 2 〉	통과 (0.04ms, 33.5MB)
// 테스트 3 〉	통과 (0.03ms, 33.4MB)
// 테스트 4 〉	통과 (0.03ms, 33.5MB)
// 테스트 5 〉	통과 (0.04ms, 33.4MB)
// 테스트 6 〉	통과 (0.03ms, 33.4MB)
// 테스트 7 〉	통과 (0.04ms, 33.4MB)
// 테스트 8 〉	통과 (0.04ms, 33.4MB)
// 테스트 9 〉	통과 (0.04ms, 33.4MB)
// 테스트 10 〉	통과 (0.05ms, 33.4MB)
// 테스트 11 〉	통과 (0.05ms, 33.5MB)
// 테스트 12 〉	통과 (0.04ms, 33.4MB)
// 테스트 13 〉	통과 (0.04ms, 33.4MB)
// 테스트 14 〉	통과 (0.05ms, 33.4MB)
// 테스트 15 〉	통과 (0.03ms, 33.4MB)
// 테스트 16 〉	통과 (0.07ms, 33.4MB)
// 테스트 17 〉	통과 (0.05ms, 33.4MB)
// 테스트 18 〉	통과 (0.05ms, 33.4MB)
// 테스트 19 〉	통과 (0.05ms, 33.5MB)
// 테스트 20 〉	통과 (0.05ms, 33.4MB)
// 테스트 21 〉	통과 (0.06ms, 33.4MB)
// 테스트 22 〉	통과 (0.03ms, 33.4MB)
// 테스트 23 〉	통과 (0.04ms, 33.4MB)
// 테스트 24 〉	통과 (0.04ms, 33.4MB)
// 테스트 25 〉	통과 (0.04ms, 33.5MB)
