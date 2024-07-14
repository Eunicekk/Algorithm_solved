function solution(num_list, n) {
    var answer = [];
    var temp = [];
    
    for (let i = 0; i < num_list.length; i++) {
        if (i % n === n - 1) {
            temp.push(num_list[i]);
            answer.push(temp);
            temp = [];
        } else {
            temp.push(num_list[i]);
        }
    }
    
    return answer;
}

// 테스트 1 〉	통과 (0.11ms, 33.5MB)
// 테스트 2 〉	통과 (0.04ms, 33.5MB)
// 테스트 3 〉	통과 (0.13ms, 33.6MB)
// 테스트 4 〉	통과 (0.04ms, 33.5MB)
// 테스트 5 〉	통과 (0.04ms, 33.5MB)
// 테스트 6 〉	통과 (0.04ms, 33.5MB)
// 테스트 7 〉	통과 (0.04ms, 33.5MB)
