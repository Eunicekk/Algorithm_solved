const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();

const s = Number(input);
let sum = 0;
let current = 0;

while (sum <= s) {
  current += 1;
  sum += current;
}

console.log(current - 1);
