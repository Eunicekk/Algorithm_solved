const fs = require("fs");
const input = fs.readFileSync("input.txt").toString().trim().split("\n");

const count = Number(input[0]);
const scores = input[1].split(" ").map(Number);

const max = scores.reduce((a, b) => Math.max(a, b));
const newScores = scores.map((value) => (value / max) * 100);
const newSum = newScores.reduce((a, b) => (a += b));

const avg = String(newSum / count);

console.log(avg.includes(".") ? avg : avg + ".0");
