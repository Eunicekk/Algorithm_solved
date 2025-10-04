const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const [count, need] = input[0].split(" ").map(Number);
const trees = input[1].split(" ").map(Number);

trees.sort((a, b) => a - b);

let start = 0;
let end = trees[count - 1];
let result = 0;

while (start <= end) {
  let mid = parseInt((start + end) / 2);
  let total = 0;

  trees.forEach((tree) => {
    total += Math.max(tree - mid, 0);
  });

  if (total >= need) {
    result = mid;
    start = mid + 1;
  } else {
    end = mid - 1;
  }
}

console.log(result);
