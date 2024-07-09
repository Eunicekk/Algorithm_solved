function solution(angle) {
    if (angle < 90) return 1;
    else if (angle === 90) return 2;
    else if (angle < 180) return 3;
    else if (angle === 180) return 4;
}

// 테스트 1 〉	통과 (0.02ms, 33.4MB)
// 테스트 2 〉	통과 (0.02ms, 33.6MB)
// 테스트 3 〉	통과 (0.02ms, 33.5MB)
// 테스트 4 〉	통과 (0.02ms, 33.5MB)
// 테스트 5 〉	통과 (0.02ms, 33.4MB)
// 테스트 6 〉	통과 (0.02ms, 33.4MB)
// 테스트 7 〉	통과 (0.02ms, 33.5MB)
// 테스트 8 〉	통과 (0.02ms, 33.4MB)
