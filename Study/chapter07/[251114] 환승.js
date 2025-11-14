const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

let [n, k, m] = input[0].split(" ").map(Number);

let stationToTube = Array.from({ length: n + 1 }, () => []);
let tubeToStation = Array.from({ length: m + 1 }, () => []);
let visitStation = Array(n + 1).fill(false);
let visitTube = Array(m + 1).fill(false);

for (let i = 1; i < m + 1; i++) {
  let stations = input[i].split(" ").map(Number);

  for (let s of stations) {
    stationToTube[s].push(i);
    tubeToStation[i].push(s);
  }
}

const bfs = () => {
  let queue = [];
  queue.push([1, 1]);
  visitStation[1] = true;

  while (queue.length > 0) {
    let [current, move] = queue.shift();

    if (current === n) {
      return move;
    }

    for (let tube of stationToTube[current]) {
      if (visitTube[tube]) {
        continue;
      }

      visitTube[tube] = true;

      for (let next of tubeToStation[tube]) {
        if (!visitStation[next]) {
          visitStation[next] = true;
          queue.push([next, move + 1]);
        }
      }
    }
  }

  return -1;
};

console.log(bfs());
