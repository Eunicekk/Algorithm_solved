function solution(my_string) {
    let text = '';
    let array = my_string.toLocaleLowerCase().split('');
    array.sort();
    
    for (const item of array) {
        text += item;
    } 
    
    return text;
}

// 테스트 1 〉	통과 (0.06ms, 33.4MB)
// 테스트 2 〉	통과 (0.06ms, 33.4MB)
// 테스트 3 〉	통과 (0.11ms, 33.4MB)
// 테스트 4 〉	통과 (0.14ms, 33.5MB)
// 테스트 5 〉	통과 (0.15ms, 33.5MB)
// 테스트 6 〉	통과 (0.15ms, 33.6MB)
