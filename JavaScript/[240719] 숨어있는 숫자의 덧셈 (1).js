function solution(my_string) {
    var number = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
    var array = my_string.split("");
    var answer = 0;
    
    for (const item of array) {
        for (const num of number) {
            if (item == num) answer += Number(item);
        }
    }
    
    return answer;
}

// 테스트 1 〉	통과 (0.17ms, 33.3MB)
// 테스트 2 〉	통과 (0.21ms, 33.5MB)
// 테스트 3 〉	통과 (0.23ms, 33.3MB)
// 테스트 4 〉	통과 (0.22ms, 33.5MB)
// 테스트 5 〉	통과 (0.16ms, 33.5MB)
// 테스트 6 〉	통과 (0.16ms, 33.4MB) asdf
