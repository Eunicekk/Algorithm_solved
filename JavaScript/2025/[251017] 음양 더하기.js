function solution(absolutes, signs) {
    let result = 0;
    
    absolutes.forEach((absolute, index) => {
        if (signs[index]) {
            result += absolute;
        } else {
            result -= absolute;
        }
    })
    
    return result;
}

// 테스트 1 〉	통과 (0.09ms, 33.5MB)
// 테스트 2 〉	통과 (0.10ms, 33.5MB)
// 테스트 3 〉	통과 (0.09ms, 33.4MB)
// 테스트 4 〉	통과 (0.10ms, 33.4MB)
// 테스트 5 〉	통과 (0.10ms, 33.4MB)
// 테스트 6 〉	통과 (0.09ms, 33.5MB)
// 테스트 7 〉	통과 (0.10ms, 33.4MB)
// 테스트 8 〉	통과 (0.10ms, 33.5MB)
// 테스트 9 〉	통과 (0.10ms, 33.5MB)
