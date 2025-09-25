const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split(" ");

const compare = (a, b) => {
  return a - b;
};

const numbers = input.map((number) => Number(number)).sort(compare);

console.log(numbers[0], numbers[1], numbers[2]);
