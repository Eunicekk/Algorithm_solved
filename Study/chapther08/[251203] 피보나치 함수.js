const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let t = Number(input[0]);
let numbers = input.slice(1).map(Number);
let max = Math.max(...numbers);

let zero = Array(max + 1).fill(0);
let one = Array(max + 1).fill(0);

zero[0] = 1;
one[0] = 0;

if (max >= 1) {
  zero[1] = 0;
  one[1] = 1;
}

for (let i = 2; i <= max; i++) {
  zero[i] = zero[i - 1] + zero[i - 2];
  one[i] = one[i - 1] + one[i - 2];
}

let result = "";

for (let i = 0; i < t; i++) {
  let n = numbers[i];
  result += `${zero[n]} ${one[n]}\n`;
}

console.log(result.trim())
