const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const compare = (a, b) => {
  return a - b;
};

const k = Number(input[0].split(" ")[1]);
const numbers = input[1].split(" ").map(Number).sort(compare);

console.log(numbers[k - 1]);
