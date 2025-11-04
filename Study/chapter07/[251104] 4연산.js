const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim();

let [start, target] = input.split(" ").map(Number);
let visit = new Set();

if (start === target) {
  console.log(0);
  process.exit(0);
}

const bfs = (start) => {
  let queue = [[start, ""]];
  visit.add(start);

  while (queue.length > 0) {
    let [current, ops] = queue.shift();

    if (current === target) {
      console.log(ops);
      process.exit(0);
    }

    const nextStates = [
      [current * current, ops + "*"],
      [current + current, ops + "+"],
      [0, ops + "-"],
      [current !== 0 ? 1 : null, ops + "/"],
    ];

    for (let [next, nextOps] of nextStates) {
      if (
        next !== null &&
        next <= Number.MAX_SAFE_INTEGER &&
        !visit.has(next)
      ) {
        visit.add(next);
        queue.push([next, nextOps]);
      }
    }
  }
};

bfs(start);

console.log(-1);
