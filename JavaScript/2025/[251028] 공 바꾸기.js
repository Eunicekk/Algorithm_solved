const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let [n, m] = input[0].split(" ").map(Number);
let balls = Array.from({ length: n + 1 }, (_, index) => index);

for (let i = 1; i < m + 1; i++) {
  let [a, b] = input[i].split(" ").map(Number);
  let temp = balls[a];
  balls[a] = balls[b];
  balls[b] = temp;
}

console.log(balls.slice(1).join(" "));
