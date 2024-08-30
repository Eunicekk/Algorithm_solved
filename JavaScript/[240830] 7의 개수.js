function solution(array) {
    var answer = 0;
    
    for (const item of array) {
        let numbers = item.toString().split("");
        for (const n of numbers) {
            if (n === '7') answer++;
        }
    }
    
    return answer;
}

// 테스트 1 〉	통과 (0.24ms, 33.5MB)
// 테스트 2 〉	통과 (0.05ms, 33.5MB)
// 테스트 3 〉	통과 (0.05ms, 33.6MB)
// 테스트 4 〉	통과 (0.22ms, 33.5MB)
