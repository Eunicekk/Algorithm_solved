const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let [n, m] = input[0].split(" ").map(Number);
let balls = Array.from({ length: n + 1 }, (_, index) => index);

for (let i = 1; i < m + 1; i++) {
  let [a, b] = input[i].split(" ").map(Number);

  for (let j = 0; j < (b - a) / 2; j++) {
    let temp = balls[a + j];
    balls[a + j] = balls[b - j];
    balls[b - j] = temp;
  }
}

console.log(balls.slice(1).join(" "));
