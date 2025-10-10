function solution(s) {
    const map = new Map();
    
    const number = s.replace(/zero/g, '0').replace(/one/g, '1')
    .replace(/two/g, '2').replace(/three/g, '3')
    .replace(/four/g, '4').replace(/five/g, '5')
    .replace(/six/g, '6').replace(/seven/g, '7')
    .replace(/eight/g, '8').replace(/nine/g, '9');
    
    return Number(number);
}

// 테스트 1 〉	통과 (0.06ms, 33.4MB)
// 테스트 2 〉	통과 (0.06ms, 33.3MB)
// 테스트 3 〉	통과 (0.06ms, 33.4MB)
// 테스트 4 〉	통과 (0.06ms, 33.4MB)
// 테스트 5 〉	통과 (0.06ms, 33.5MB)
// 테스트 6 〉	통과 (0.07ms, 33.4MB)
// 테스트 7 〉	통과 (0.09ms, 33.3MB)
// 테스트 8 〉	통과 (0.06ms, 33.4MB)
// 테스트 9 〉	통과 (0.06ms, 33.4MB)
// 테스트 10 〉	통과 (0.06ms, 33.4MB)
