function solution(my_string, num1, num2) {
    const array = my_string.split("")
    
    var temp = array[num1];
    array[num1] = array[num2];
    array[num2] = temp;
    
    var answer = "";
    
    for (const item of array) {
        answer += item;
    }
    
    return answer;
}

// 테스트 1 〉	통과 (0.05ms, 33.5MB)
// 테스트 2 〉	통과 (0.05ms, 33.6MB)
// 테스트 3 〉	통과 (0.05ms, 33.5MB)
// 테스트 4 〉	통과 (0.05ms, 33.4MB)
