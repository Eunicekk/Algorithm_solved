const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const compare = (a, b) => {
  return a - b;
};

const numbers = input[1].split(" ").map(Number);
const sorted = [...new Set([...numbers])].sort(compare);
const rank = {};

sorted.forEach((number, index) => {
  rank[number] = index;
})

console.log(numbers.map((number) => rank[number]).join(" "));
