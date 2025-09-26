const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("");

const compare = (a, b) => {
  return b - a;
};

const numbers = input.map(Number).sort(compare).join("");

console.log(numbers);
