const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const N = Number(input[0]);
let result = 0;

out: for (let n = 1; n <= N; n++) {
  const set = new Set();
  const words = input[n].split("");

  for (let i = 0; i < words.length; i++) {
    if (!set.has(words[i])) {
      set.add(words[i]);
    } else {
      if (words[i] !== words[i - 1]) {
        continue out;
      }
    }
  }

  result++;
}

console.log(result);
