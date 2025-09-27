const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();

const parts = input.split("-");
let result = 0;

const firstPart = parts[0]
  .split("+")
  .map(Number)
  .reduce((a, b) => a + b, 0);
result += firstPart;

for (let i = 1; i < parts.length; i++) {
  const sum = parts[i]
    .split("+")
    .map(Number)
    .reduce((a, b) => a + b, 0);
  result -= sum;
}

console.log(result);
