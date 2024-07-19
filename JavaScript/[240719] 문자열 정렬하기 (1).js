function solution(my_string) {
    var number = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
    var array = my_string.split("");
    var answer = [];
    
    for (const item of array) {
        for (const num of number) {
            if (item == num) answer.push(Number(item));
        }
    }
    
    return answer.sort((a, b) => a - b);
}

// 테스트 1 〉	통과 (0.20ms, 32.2MB)
// 테스트 2 〉	통과 (0.20ms, 33.4MB)
// 테스트 3 〉	통과 (0.31ms, 33.5MB)
// 테스트 4 〉	통과 (0.20ms, 32.1MB)
