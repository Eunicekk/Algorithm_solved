const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const array = input.map(Number);
let value = array[0];
let index = 1;

for (let i = 1; i < 9; i++) {
  if (value < array[i]) {
    value = array[i];
    index = i + 1;
  }
}

console.log(value);
console.log(index);
