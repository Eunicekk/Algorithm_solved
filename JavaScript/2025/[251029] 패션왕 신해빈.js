const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let T = Number(input[0]);
let index = 1;

for (let t = 0; t < T; t++) {
  let length = Number(input[index++]);
  let map = new Map();

  for (let i = 0; i < length; i++) {
    let [cloth, type] = input[index++].split(" ");
    map.set(type, (map.get(type) ?? 0) + 1);
  }

  let result = 1;

  for (let [_, value] of map) {
    result *= value + 1;
  }

  console.log(result - 1);
}
