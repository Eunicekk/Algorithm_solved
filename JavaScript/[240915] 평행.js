function solution(dots) {
    let answer = 0;
    
    function parallel(p1, p2, p3, p4) {
        return (p2[1] - p1[1]) * (p4[0] - p3[0]) === (p4[1] - p3[1]) * (p2[0] - p1[0]);
    }
    
    if (parallel(dots[0], dots[1], dots[2], dots[3]) || parallel(dots[0], dots[2], dots[1], dots[3]) || parallel(dots[0], dots[3], dots[1], dots[2])) {
        answer = 1;
    }
    
    return answer;
}

// 테스트 1 〉	통과 (0.05ms, 33.3MB)
// 테스트 2 〉	통과 (0.05ms, 33.4MB)
// 테스트 3 〉	통과 (0.05ms, 33.4MB)
// 테스트 4 〉	통과 (0.05ms, 33.3MB)
// 테스트 5 〉	통과 (0.05ms, 33.3MB)
// 테스트 6 〉	통과 (0.05ms, 33.4MB)
// 테스트 7 〉	통과 (0.07ms, 33.3MB)
// 테스트 8 〉	통과 (0.05ms, 33.3MB)
// 테스트 9 〉	통과 (0.08ms, 33.4MB)
// 테스트 10 〉	통과 (0.05ms, 33MB)
// 테스트 11 〉	통과 (0.05ms, 32.9MB)
// 테스트 12 〉	통과 (0.05ms, 33.3MB)
// 테스트 13 〉	통과 (0.05ms, 33.3MB)
// 테스트 14 〉	통과 (0.05ms, 33.3MB)
// 테스트 15 〉	통과 (0.05ms, 33.4MB)
// 테스트 16 〉	통과 (0.08ms, 33.3MB)
// 테스트 17 〉	통과 (0.08ms, 33.4MB)
