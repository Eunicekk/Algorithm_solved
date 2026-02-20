function solution(numbers) {
    var answer = 0;
    numbers.forEach(num => {
        answer += num;
    })
    
    return parseFloat(answer / numbers.length);
}

// 테스트 1 〉	통과 (0.04ms, 33.5MB)
// 테스트 2 〉	통과 (0.04ms, 33.4MB)
// 테스트 3 〉	통과 (0.06ms, 33.5MB)
// 테스트 4 〉	통과 (0.04ms, 33.4MB)
// 테스트 5 〉	통과 (0.05ms, 33.5MB)
