const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let n = Number(input[0]);
let triangle = [];

for (let i = 1; i <= n; i++) {
  triangle.push(input[i].split(" ").map(Number));
}

for (let i = n - 2; i >= 0; i--) {
  for (let j = 0; j < triangle[i].length; j++) {
    triangle[i][j] =
      triangle[i][j] + Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
  }
}

console.log(triangle[0][0]);
