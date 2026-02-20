function solution(array) {
    var newArray = new Array(1001).fill(0);
    
    for (let i = 0; i < array.length; i++) {
        newArray[array[i]]++;
    }
    
    var max = Math.max(...newArray);
    var count = 0;
    var index = 0;
    
    console.log(max)
    
    for (let i = 0; i < newArray.length; i++) {
        if (max === newArray[i]) {
            count++;
            index = i;
        }
    }
    
    return count === 1 ? index : -1;
}

// 테스트 1 〉	통과 (2.29ms, 33.7MB)
// 테스트 2 〉	통과 (2.28ms, 33.5MB)
// 테스트 3 〉	통과 (2.45ms, 33.6MB)
// 테스트 4 〉	통과 (2.43ms, 33.6MB)
// 테스트 5 〉	통과 (2.35ms, 33.7MB)
// 테스트 6 〉	통과 (2.37ms, 33.5MB)
// 테스트 7 〉	통과 (2.23ms, 33.6MB)
// 테스트 8 〉	통과 (2.34ms, 33.7MB)
// 테스트 9 〉	통과 (2.26ms, 33.5MB)
// 테스트 10 〉	통과 (2.24ms, 33.5MB)
// 테스트 11 〉	통과 (2.23ms, 33.5MB)
// 테스트 12 〉	통과 (2.49ms, 33.5MB)
// 테스트 13 〉	통과 (2.28ms, 33.5MB)
// 테스트 14 〉	통과 (2.26ms, 33.2MB)
// 테스트 15 〉	통과 (2.25ms, 33.3MB)
// 테스트 16 〉	통과 (2.47ms, 33.6MB)
