const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const compare = (a, b) => {
  return a - b;
};

const numbers = input.slice(1).map(Number).sort(compare);

numbers.forEach((number) => {
  console.log(number);
});
