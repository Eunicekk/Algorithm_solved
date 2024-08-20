function solution(array) {
    var answer = [];
    const sortArray = [];
    
    for (const item of array) {
        sortArray.push(item);
    }
    
    sortArray.sort((a, b) => b - a)
    answer.push(sortArray[0]);
    
    for (let i = 0; i < array.length; i++) {
        if (array[i] === sortArray[0]) answer.push(i);
    }
    
    return answer;
}

// 테스트 1 〉	통과 (0.09ms, 33.6MB)
// 테스트 2 〉	통과 (0.08ms, 33.4MB)
