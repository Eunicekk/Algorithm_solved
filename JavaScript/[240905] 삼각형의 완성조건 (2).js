function solution(sides) {
    let count = 0;
    sides.sort((a, b) => a - b);
    
    for (let i = sides[1]; i < sides[0] + sides[1]; i++) {
        count++;
    }

    for (let i = sides[1] + 1; i < sides[0] + sides[1]; i++) {
        count++;
    }
    
    return count;
}

// 테스트 1 〉	통과 (0.05ms, 33.4MB)
// 테스트 2 〉	통과 (0.14ms, 33.4MB)
// 테스트 3 〉	통과 (0.07ms, 33.4MB)
// 테스트 4 〉	통과 (0.05ms, 33.5MB)
// 테스트 5 〉	통과 (0.12ms, 33.4MB)
// 테스트 6 〉	통과 (0.05ms, 33.5MB)
// 테스트 7 〉	통과 (0.17ms, 33.5MB)
// 테스트 8 〉	통과 (0.05ms, 33.5MB)
// 테스트 9 〉	통과 (0.05ms, 33.4MB)
// 테스트 10 〉	통과 (0.05ms, 33.4MB)
