const fs = require("fs");
const input = fs.readFileSync("input.txt").toString().trim().split("\n");

let map = new Map();
let total = 0;

for (let word of input) {
  word = word.trim();
  if (word) {
    map.set(word, (map.get(word) ?? 0) + 1);
    total++;
  }
}

let sorted = [...map.entries()].sort(([a], [b]) => {
  if (a < b) return -1;
  if (a > b) return 1;
  return 0;
});

for (let [key, value] of sorted) {
  console.log(`${key} ${((value / total) * 100).toFixed(4)}`);
}
