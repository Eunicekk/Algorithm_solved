const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let [n, m] = input[0].split(" ").map(Number);
let basket = new Array(n + 1).fill(0);

for (let i = 1; i < m + 1; i++) {
  let [a, b, c] = input[i].split(" ").map(Number);

  for (let j = a; j <= b; j++) {
    basket[j] = c;
  }
}

console.log(basket.slice(1).join(" "));
