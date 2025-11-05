const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

class PriorityQueue {
  constructor() {
    this.heap = [];
  }

  isEmpty() {
    return this.heap.length === 0;
  }

  push(node) {
    this.heap.push(node);
    this._up();
  }

  pop() {
    if (this.heap.length === 0) {
      return null;
    }

    if (this.heap.length === 1) {
      return this.heap.pop();
    }

    let min = this.heap[0];
    this.heap[0] = this.heap.pop();
    this._down();
    return min;
  }

  _up() {
    let index = this.heap.length - 1;

    while (index > 0) {
      let parent = Math.floor((index - 1) / 2);

      if (this.heap[parent][1] <= this.heap[index][1]) {
        break;
      }

      [this.heap[parent], this.heap[index]] = [
        this.heap[index],
        this.heap[parent],
      ];
      index = parent;
    }
  }

  _down() {
    let index = 0;
    let length = this.heap.length;

    while (true) {
      let left = index * 2 + 1;
      let right = index * 2 + 2;
      let min = index;

      if (left < length && this.heap[left][1] < this.heap[min][1]) {
        min = left;
      }

      if (right < length && this.heap[right][1] < this.heap[min][1]) {
        min = right;
      }

      if (min === index) {
        break;
      }

      [this.heap[index], this.heap[min]] = [this.heap[min], this.heap[index]];
      index = min;
    }
  }
}

const dijkstra = (start, graph, dist) => {
  let pq = new PriorityQueue();
  pq.push([start, 0]);
  dist[start] = 0;

  while (!pq.isEmpty()) {
    let [current, cost] = pq.pop();

    if (dist[current] < cost) {
      continue;
    }

    for (let [next, nextCost] of graph[current]) {
      let newCost = cost + nextCost;

      if (newCost < dist[next]) {
        dist[next] = newCost;
        pq.push([next, newCost]);
      }
    }
  }
};

let [v, e] = input[0].split(" ").map(Number);
let k = Number(input[1]);
let graph = Array.from({ length: v + 1 }, () => []);
let dist = Array(v + 1).fill(Infinity);

for (let i = 2; i < e + 2; i++) {
  let [a, b, c] = input[i].split(" ").map(Number);
  graph[a].push([b, c]);
}

dijkstra(k, graph, dist);

let result = "";

for (let i = 1; i <= v; i++) {
  result += (dist[i] === Infinity ? "INF" : dist[i]) + "\n";
}

console.log(result.trim());
