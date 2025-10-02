const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const n = Number(input[0]);
const roads = input[1].split(" ").map(BigInt);
const costs = input[2].split(" ").map(BigInt);

let minCost = costs[0];
let result = 0n;

for (let i = 0; i < n - 1; i++) {
  if (costs[i] < minCost) {
    minCost = costs[i];
  }

  result += minCost * roads[i];
}

console.log(result.toString());
