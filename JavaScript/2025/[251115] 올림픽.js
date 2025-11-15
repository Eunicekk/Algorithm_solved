const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let [n, k] = input[0].split(" ").map(Number);
let array = [];

for (let i = 1; i < n + 1; i++) {
  let [index, gold, silver, bronze] = input[i].split(" ").map(Number);
  array.push({ index, gold, silver, bronze });
}

array.sort((a, b) => {
  if (a.gold !== b.gold) {
    return b.gold - a.gold;
  }

  if (a.silver !== b.silver) {
    return b.silver - a.silver;
  }

  return b.bronze - a.bronze;
});

let target = array.find((c) => c.index === k);
let rank = 1;

for (let i = 0; i < array.length; i++) {
  let current = array[i];

  if (
    current.gold > target.gold ||
    (current.gold === target.gold && current.silver > target.silver) ||
    (current.gold === target.gold &&
      current.silver === target.silver &&
      current.bronze > target.bronze)
  ) {
    rank++;
  }
}

console.log(rank);
