const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let n = Number(input[0]);
let state = input[1].split(" ").map(Number);
let m = Number(input[2]);

for (let i = 3; i < m + 3; i++) {
  let [gender, number] = input[i].split(" ").map(Number);

  if (gender === 1) {
    let button = number;

    while (button <= n) {
      state[button - 1] = state[button - 1] === 1 ? 0 : 1;
      button += number;
    }
  } else if (gender === 2) {
    let left = number - 1;
    let right = number - 1;

    while (
      left - 1 >= 0 &&
      right + 1 < n &&
      state[left - 1] === state[right + 1]
    ) {
      left--;
      right++;
    }

    for (let j = left; j <= right; j++) {
      state[j] = state[j] === 1 ? 0 : 1;
    }
  }
}

for (let i = 0; i < state.length; i += 20) {
  console.log(state.slice(i, i + 20).join(" "));
}
