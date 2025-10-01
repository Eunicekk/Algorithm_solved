const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();

const n = Number(input);
const five = parseInt(n / 5);
let result = Number.MAX_SAFE_INTEGER;

for (let i = five; i >= 0; i--) {
  if ((n - 5 * i) % 3 === 0) {
    result = Math.min(result, i + parseInt((n - 5 * i) / 3));
  }
}

console.log(result === Number.MAX_SAFE_INTEGER ? -1 : result);
