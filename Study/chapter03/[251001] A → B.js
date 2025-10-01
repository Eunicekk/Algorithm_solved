const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split(" ");

let a = Number(input[0]);
let b = Number(input[1]);
let result = 1;

while (a < b) {
  if (b % 2 === 0) {
    b /= 2;
    result++;
  } else if (b.toString().slice(-1) === "1") {
    b = Number(b.toString().slice(0, -1));
    result++;
  } else {
    break;
  }
}

console.log(a === b ? result : -1);
