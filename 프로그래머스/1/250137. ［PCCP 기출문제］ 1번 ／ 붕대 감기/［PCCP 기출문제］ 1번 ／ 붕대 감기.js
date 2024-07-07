function solution(bandage, health, attacks) {
    var HP = health; // 내 HP
    var ongoing = 0; // 진행 시간
    var maxTime = attacks[attacks.length - 1][0]; // 공격 시간
    var index = 0;
    
    for (let i = 1; i <= maxTime; i++) {
        if (i === attacks[index][0]) {
            HP -= attacks[index][1];
            if (HP <= 0) return -1;
            ongoing = 0;
            index++;
        } else {
            ongoing++;
            if (HP < health) {
                HP + bandage[1] > health ? HP = health : HP += bandage[1];
            }
                
            if (ongoing === bandage[0]) {
                HP + bandage[2] > health ? HP = health : HP += bandage[2];
                ongoing = 0;
            }
        }
    }
    
    return HP;
}