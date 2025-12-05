const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let n = Number(input[0]);
let array = input.slice(1).map(Number);

let current = array[0];
let result = array[0];

for (let i = 1; i < n; i++) {
  current = Math.max(array[i], current * array[i]);
  result = Math.max(result, current);
}

console.log(result.toFixed(3));
