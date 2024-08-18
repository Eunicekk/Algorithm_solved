function solution(numbers) {
    const array = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];
    var answer = numbers;
    
    for (let i = 0; i <= 9; i++) {
        answer = answer.replaceAll(array[i], i);
    }
    
    return Number(answer);
}

// 테스트 1 〉	통과 (0.05ms, 33.5MB)
// 테스트 2 〉	통과 (0.05ms, 33.5MB)
// 테스트 3 〉	통과 (0.05ms, 33.5MB)
// 테스트 4 〉	통과 (0.04ms, 33.5MB)
// 테스트 5 〉	통과 (0.04ms, 33.4MB)
// 테스트 6 〉	통과 (0.04ms, 33.4MB)
// 테스트 7 〉	통과 (0.05ms, 33.5MB)
// 테스트 8 〉	통과 (0.04ms, 33.5MB)
// 테스트 9 〉	통과 (0.05ms, 33.5MB)
