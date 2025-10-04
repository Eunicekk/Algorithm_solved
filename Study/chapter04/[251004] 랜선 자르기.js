const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const [k, n] = input[0].split(" ").map(Number);
const lines = input.slice(1).map(Number);

lines.sort((a, b) => a - b);

let start = 1;
let end = lines[k - 1];
let result = 0;

while (start <= end) {
  let mid = parseInt((start + end) / 2);
  let count = 0;

  lines.forEach((line) => {
    count += parseInt(line / mid);
  });

  if (count >= n) {
    result = mid;
    start = mid + 1;
  } else {
    end = mid - 1;
  }
}

console.log(result);
