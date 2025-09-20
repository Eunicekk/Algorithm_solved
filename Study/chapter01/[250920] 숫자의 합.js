const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");

const count = Number(input[0]);
const numbers = input[1].split("").map(Number);

let sum = 0;

for (const num of numbers) {
  sum += num;
}

console.log(sum);
