function solution(friends, gifts) {
    const n = friends.length;
    
    const map = new Map();
    friends.forEach((friend, index) => map.set(friend, index));
    
    const score = new Array(n).fill(0);
    const record = Array.from({length: n}, () => Array(n).fill(0));
    
    gifts.forEach((gift) => {
        const [give, get] = gift.split(" ");
        const giveIndex = map.get(give);
        const getIndex = map.get(get);
        
        score[giveIndex] += 1;
        score[getIndex] -= 1;
        record[giveIndex][getIndex] += 1;
    })
    
    let max = 0;
    
    for (let i = 0; i < n; i++) {
        let count = 0;
        
        for (let j = 0; j < n; j++) {
            if (i === j) {
                continue;                
            }
            
            if (record[i][j] > record[j][i]) {
                count++;
            } else if (record[i][j] === record[j][i] && score[i] > score[j]) {
                count++;
            }
            
            max = Math.max(max, count);
        }
    }
    
    return max;
}

// 테스트 1 〉	통과 (0.43ms, 33.5MB)
// 테스트 2 〉	통과 (0.32ms, 33.6MB)
// 테스트 3 〉	통과 (0.60ms, 33.6MB)
// 테스트 4 〉	통과 (0.50ms, 33.5MB)
// 테스트 5 〉	통과 (3.34ms, 36.9MB)
// 테스트 6 〉	통과 (0.83ms, 33.5MB)
// 테스트 7 〉	통과 (2.61ms, 33.7MB)
// 테스트 8 〉	통과 (2.37ms, 33.7MB)
// 테스트 9 〉	통과 (5.55ms, 37.7MB)
// 테스트 10 〉	통과 (5.75ms, 37.9MB)
// 테스트 11 〉	통과 (5.42ms, 38MB)
// 테스트 12 〉	통과 (7.57ms, 37.6MB)
// 테스트 13 〉	통과 (13.38ms, 38.2MB)
// 테스트 14 〉	통과 (10.33ms, 38MB)
// 테스트 15 〉	통과 (13.68ms, 38.3MB)
// 테스트 16 〉	통과 (13.55ms, 38.2MB)
// 테스트 17 〉	통과 (0.61ms, 33.5MB)
// 테스트 18 〉	통과 (5.79ms, 37.8MB)
// 테스트 19 〉	통과 (12.20ms, 38.2MB)
// 테스트 20 〉	통과 (5.92ms, 37.2MB)
