function solution(sides) {
    var answer = 0;
    sides.sort((a, b) => b - a);
    
    if (sides[0] < sides[1] + sides[2]) answer = 1;
    else answer = 2;
    
    return answer;
}

// 테스트 1 〉	통과 (0.04ms, 33.4MB)
// 테스트 2 〉	통과 (0.04ms, 33.4MB)
// 테스트 3 〉	통과 (0.06ms, 33.6MB)
// 테스트 4 〉	통과 (0.04ms, 33.5MB)
// 테스트 5 〉	통과 (0.04ms, 33.6MB)
// 테스트 6 〉	통과 (0.05ms, 33.5MB)
// 테스트 7 〉	통과 (0.04ms, 33.4MB)
// 테스트 8 〉	통과 (0.04ms, 33.4MB)
// 테스트 9 〉	통과 (0.05ms, 33.4MB)
