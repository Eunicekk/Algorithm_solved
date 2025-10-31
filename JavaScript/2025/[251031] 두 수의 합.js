const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let n = Number(input[0]);
let array = input[1]
  .split(" ")
  .map(Number)
  .sort((a, b) => a - b);
let target = Number(input[2]);
let result = 0;

let left = 0;
let right = n - 1;

while (left < right) {
  const sum = array[left] + array[right];

  if (sum === target) {
    result++;
    left++;
    right--;
  } else if (sum < target) {
    left++;
  } else {
    right--;
  }
}

console.log(result);
