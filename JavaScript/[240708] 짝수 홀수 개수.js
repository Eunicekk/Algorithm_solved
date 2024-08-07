function solution(num_list) {
    var odd = num_list.filter((item) => item % 2 === 1);
    var even = num_list.filter((item) => item % 2 === 0);
    
    var answer = [];
    answer.push(even.length);
    answer.push(odd.length);
    return answer;
}

// 테스트 1 〉	통과 (0.12ms, 33.4MB)
// 테스트 2 〉	통과 (0.05ms, 33.4MB)
// 테스트 3 〉	통과 (0.12ms, 33.5MB)
// 테스트 4 〉	통과 (0.06ms, 33.4MB)
// 테스트 5 〉	통과 (0.06ms, 33.4MB)
