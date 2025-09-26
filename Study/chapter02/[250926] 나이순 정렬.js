const { KeyObject } = require("crypto");
const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const compare = (a, b) => {
  if (a.age !== b.age) {
    return a.age - b.age;
  } else {
    return a.order - b.order;
  }
};

const users = [];

for (let i = 1; i <= Number(input[0]); i++) {
  users.push({
    order: i,
    age: Number(input[i].split(" ")[0]),
    name: input[i].split(" ")[1],
  });
}

users.sort(compare).forEach((user) => {
  console.log(user.age, user.name);
});
