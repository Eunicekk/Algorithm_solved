const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let T = Number(input[0]);
let index = 1;

for (let t = 0; t < T; t++) {
  let command = input[index++].split("");
  let length = Number(input[index++]);
  let numbers = input[index++].slice(1, -1).split(",").map(Number);

  let left = 0;
  let right = length - 1;
  let isReverse = false;
  let isError = false;

  for (let value of command) {
    if (value === "R") {
      isReverse = !isReverse;
    } else if (value === "D") {
      if (left > right) {
        isError = true;
        break;
      }

      if (!isReverse) {
        left++;
      } else {
        right--;
      }
    }
  }

  if (isError) {
    console.log("error");
  } else {
    let result = numbers.slice(left, right + 1);

    if (isReverse) {
      result.reverse();
    }

    console.log("[" + result.join(",") + "]");
  }
}
