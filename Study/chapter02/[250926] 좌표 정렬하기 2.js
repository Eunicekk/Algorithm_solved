const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const compare = (a, b) => {
  return a[1] !== b[1] ? a[1] - b[1] : a[0] - b[0];
};

const coordinates = input.slice(1).map((str) => str.split(" ").map(Number));

coordinates.sort(compare).forEach((coordinate) => {
  console.log(coordinate[0], coordinate[1]);
});
