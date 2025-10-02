const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const n = Number(input[0]);
const array = input[1].split(" ").map(Number);

const maxHeight = Math.max(...array);
const arrows = new Array(maxHeight + 1).fill(0);

let result = 0;

for (let h of array) {
  if (arrows[h] > 0) {
    arrows[h]--;
    arrows[h - 1]++;
  } else {
    result++;
    arrows[h - 1]++;
  }
}

console.log(result);
