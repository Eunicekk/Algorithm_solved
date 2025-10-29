const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let [n, c] = input[0].split(" ").map(Number);
let array = input[1].split(" ").map(Number);
let map = new Map();

array.forEach((value) => {
  map.set(value, (map.get(value) ?? 0) + 1);
});

let sorted = [...map.entries()].sort(([a1, a2], [b1, b2]) => b2 - a2);
let result = [];

sorted.forEach(([key, value]) => {
  for (let i = 0; i < value; i++) {
    result.push(key);
  }
});

console.log(result.join(" "));
