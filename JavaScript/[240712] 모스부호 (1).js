function solution(letter) {
    morse = { 
        '.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f',
        '--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l',
        '--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r',
        '...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x',
        '-.--':'y','--..':'z'
    }
    
    var array = letter.split(" ");
    var str = "";
    
    for (const item of array) {
        for (const alpha in morse) {
            if (item === alpha) str += morse[alpha];
        }
    }
    
    return str;
}

// 테스트 1 〉	통과 (0.21ms, 33.4MB)
// 테스트 2 〉	통과 (0.19ms, 33.4MB)
// 테스트 3 〉	통과 (0.22ms, 33.5MB)
// 테스트 4 〉	통과 (0.19ms, 33.4MB)
// 테스트 5 〉	통과 (0.19ms, 33.4MB)
// 테스트 6 〉	통과 (0.21ms, 33.5MB)
// 테스트 7 〉	통과 (0.22ms, 33.5MB)
