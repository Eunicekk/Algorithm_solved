function solution(my_string) {
    var array = my_string.split("");
    array.reverse();
    var answer = "";
    for (const item of array) {
        answer += item;
    }
    return answer;
}

// 테스트 1 〉	통과 (0.04ms, 33.1MB)
// 테스트 2 〉	통과 (0.07ms, 33MB)
// 테스트 3 〉	통과 (0.05ms, 33.3MB)
// 테스트 4 〉	통과 (0.04ms, 33MB)
// 테스트 5 〉	통과 (0.04ms, 32.9MB)
