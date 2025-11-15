const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let n = Number(input[0]);
let array = [];
let result = Array.from({ length: n - 1 }, () => Array(n).fill(0));

for (let i = 1; i < n + 1; i++) {
  array.push(input[i].split(" ").map(Number));
}

result.push(input[n].split(" ").map(Number));

for (let i = n - 2; i >= 0; i--) {
  for (let j = 0; j < n - 1; j++) {
    result[i][j] =
      array[i][j] + Math.max(result[i + 1][j], result[i + 1][j + 1]);
  }
}

console.log(result[0][0]);
