function solution(numbers, target) {
    let result = 0;
    
    const dfs = (depth, sum) => {
        if (depth === numbers.length) {
            if (sum === target) result++;
            return;
        }

        dfs(depth + 1, sum + numbers[depth]);
        dfs(depth + 1, sum - numbers[depth]);
    }
    
    dfs(0, 0);
    
    return result;
}

// 정확성  테스트
// 테스트 1 〉	통과 (13.89ms, 35.5MB)
// 테스트 2 〉	통과 (13.80ms, 35.3MB)
// 테스트 3 〉	통과 (0.21ms, 33.4MB)
// 테스트 4 〉	통과 (0.41ms, 33.3MB)
// 테스트 5 〉	통과 (1.82ms, 35.5MB)
// 테스트 6 〉	통과 (0.27ms, 33.4MB)
// 테스트 7 〉	통과 (0.32ms, 33.4MB)
// 테스트 8 〉	통과 (1.07ms, 35.4MB)
