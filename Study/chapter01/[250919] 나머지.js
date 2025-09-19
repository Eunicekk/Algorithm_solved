const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const array = new Array(41).fill(0);
const numbers = input.map(Number);
let result = 0;

for (const num of numbers) {
  array[num % 42]++;
}

for (const count of array) {
  if (count !== 0) {
    result++;
  }
}

console.log(result);
